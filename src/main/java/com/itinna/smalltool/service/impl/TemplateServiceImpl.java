/**
 * 
 */
package com.itinna.smalltool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itinna.smalltool.common.exception.ServiceException;
import com.itinna.smalltool.dao.mapper.AttachmentMapper;
import com.itinna.smalltool.dao.mapper.NodeMapper;
import com.itinna.smalltool.dao.mapper.ReportMapper;
import com.itinna.smalltool.dao.mapper.ReportValueMapper;
import com.itinna.smalltool.dao.mapper.TemplateMapper;
import com.itinna.smalltool.dao.mapper.UserTemplateMapper;
import com.itinna.smalltool.dao.model.Attachment;
import com.itinna.smalltool.dao.model.Node;
import com.itinna.smalltool.dao.model.Report;
import com.itinna.smalltool.dao.model.ReportValue;
import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.dao.model.UserTemplate;
import com.itinna.smalltool.service.TemplateService;
import com.itinna.smalltool.web.form.template.CreateSaveTemplateForm;
import com.itinna.smalltool.web.form.template.DeleteTemplateForm;
import com.itinna.smalltool.web.form.template.ModifySaveTemplateForm;
import com.itinna.smalltool.web.form.template.ModifyTemplateForm;
import com.itinna.smalltool.web.form.template.SearchTemplateForm;
import com.itinna.smalltool.web.form.template.ViewTemplateForm;
import com.itinna.smalltool.web.view.ModifyTemplateView;
import com.itinna.smalltool.web.view.NodeView;
import com.itinna.smalltool.web.view.SearchTemplateView;
import com.itinna.smalltool.web.view.TemplateView;
import com.itinna.smalltool.web.view.ViewTemplateView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月16日 下午12:30:55
 */
@Service
public class TemplateServiceImpl extends BaseServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private UserTemplateMapper userTemplateMapper;

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private ReportValueMapper reportValueMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.itinna.smalltool.service.TemplateService#createSave(com.itinna.
     * smalltool.web.form.template.CreateSaveTemplateForm)
     */
    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ViewTemplateView createSave(CreateSaveTemplateForm form) {
        // insert template
        String userId = form.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("no user");
        }
        Template template = form.getTemplate();
        if (template == null) {
            throw new ServiceException("no template");
        }
        String templateId = Template.generateID();
        template.setId(templateId);
        template.setCreator(userId);
        template.setModifier(userId);
        this.templateMapper.insert(template);

        // insert user_template for admin
        this.createAdmins(form.getAdminIds(), templateId, userId);

        // insert user_template for reporter
        this.createReporters(form.getReporterIds(), templateId, userId);

        // insert node
        this.createNodes(template.getNodes(), templateId, userId, TOP_NODE_PARENT_ID);

        // set return value
        return this.view(templateId);
    }

    private void createAdmins(List<String> admins, String templateId, String userId) {
        if (admins == null) {
            admins = new ArrayList<String>();
        }
        admins.add(userId);
        for (String adminId : admins) {
            UserTemplate userTemplate = new UserTemplate();
            userTemplate.setId(UserTemplate.generateID());
            userTemplate.setUserId(adminId);
            userTemplate.setTemplateId(templateId);
            userTemplate.setIsAdmin(TEMPLATE_ADMIN);
            userTemplate.setCreator(userId);
            userTemplate.setModifier(userId);
            this.userTemplateMapper.insertSelective(userTemplate);
        }
    }

    private void createReporters(List<String> reporters, String templateId, String userId) {
        if (reporters != null && reporters.size() > 0) {
            for (String reporterId : reporters) {
                UserTemplate userTemplate = new UserTemplate();
                userTemplate.setId(UserTemplate.generateID());
                userTemplate.setUserId(reporterId);
                userTemplate.setTemplateId(templateId);
                userTemplate.setIsAdmin(TEMPLATE_NOT_ADMIN);
                userTemplate.setCreator(userId);
                userTemplate.setModifier(userId);
                this.userTemplateMapper.insertSelective(userTemplate);
            }
        }
    }

    private void createNodes(List<Node> nodes, String templateId, String userId, String parentId) {
        if (nodes != null && nodes.size() > 0) {
            for (Node node : nodes) {
                String nodeId = Node.generateID();
                node.setId(nodeId);
                node.setParentId(parentId);
                node.setTemplateId(templateId);
                node.setCreator(userId);
                node.setModifier(userId);
                this.nodeMapper.insertSelective(node);

                List<Node> subNodes = node.getSubNodes();
                if (subNodes != null && subNodes.size() > 0) {
                    parentId = node.getId();
                    modifyNodes(subNodes, templateId, userId, parentId);
                }
            }
        }
    }

    private TemplateView getTemplateView(Template template) {
        TemplateView view = new TemplateView();
        view.setId(template.getId());
        view.setName(template.getName());
        view.setDescription(template.getDescription());

        List<Node> nodes = template.getNodes();
        if (nodes != null && nodes.size() > 0) {
            List<NodeView> nodeViews = new ArrayList<NodeView>();
            view.setNodes(nodeViews);
            for (Node node : nodes) {
                NodeView nodeView = new NodeView();
                nodeViews.add(nodeView);
                nodeView.setId(node.getId());
                nodeView.setName(node.getName());
                nodeView.setNodeTypeId(node.getNodeTypeId());
                nodeView.setPosition(node.getPosition());
                nodeView.setIsRequired(node.getIsRequired());
                nodeView.setHasAttachment(node.getHasAttachment());
            }
        }
        return view;
    }

    @Override
    public ModifyTemplateView modify(ModifyTemplateForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ViewTemplateView modifySave(ModifySaveTemplateForm form) {
        // update template
        Template template = form.getTemplate();
        if (template == null) {
            throw new ServiceException("no template");
        }
        String userId = form.getUserId();
        if (userId == null) {
            throw new ServiceException("no user");
        }
        template.setModifier(userId);
        this.templateMapper.updateByPrimaryKeySelective(template);

        // update node
        String templateId = template.getId();
        this.deleteNodes(template.getNodes(), templateId);
        this.modifyNodes(template.getNodes(), templateId, userId, TOP_NODE_PARENT_ID);

        // update user_template
        this.deleteAdminsAndReporters(templateId);
        this.modifyAdmins(form.getAdmins(), templateId, userId);
        this.modifyReporters(form.getReporters(), templateId, userId);

        return this.view(templateId);
    }

    private void deleteAdminsAndReporters(String templateId) {
        List<UserTemplate> userTemplates = this.userTemplateMapper.selectByTemplateId(templateId);
        if (userTemplates != null && userTemplates.size() > 0) {
            for (UserTemplate userTemplate : userTemplates) {
                this.userTemplateMapper.deleteByPrimaryKey(userTemplate.getId());
            }
        }
    }

    private void modifyAdmins(List<String> admins, String templateId, String userId) {
        this.createAdmins(admins, templateId, userId);
    }

    private void modifyReporters(List<String> reporters, String templateId, String userId) {
        this.createReporters(reporters, templateId, userId);
    }

    private void deleteNodes(List<Node> nodes, String templateId) {
        // add web node id to a list
        List<String> webNodeIds = this.getWebNodeIds(nodes, null);

        // 删除表单里没有包含的数据库里的node
        List<Node> dbNodes = this.nodeMapper.selectByTemplateId(templateId);
        if (dbNodes != null) {
            for (Node dbNode : dbNodes) {
                String dbNodeId = dbNode.getId();
                if (webNodeIds == null || !webNodeIds.contains(dbNodeId)) {
                    this.nodeMapper.deleteByPrimaryKey(dbNodeId);
                }
            }
        }
    }

    private List<String> getWebNodeIds(List<Node> nodes, List<String> webNodeIds) {
        if (nodes != null) {
            for (Node webNode : nodes) {
                if (webNodeIds == null) {
                    webNodeIds = new ArrayList<String>();
                }
                webNodeIds.add(webNode.getId());
                this.getWebNodeIds(webNode.getSubNodes(), webNodeIds);
            }
        }
        return webNodeIds;
    }

    private void modifyNodes(List<Node> nodes, String templateId, String userId, String parentId) {
        if (nodes != null && nodes.size() > 0) {
            for (Node node : nodes) {
                String nodeId = node.getId();
                Node dbNode = this.nodeMapper.selectByPrimaryKey(nodeId);
                if (dbNode == null) { // new node to create
                    nodeId = Node.generateID();
                    node.setId(nodeId);
                    node.setParentId(parentId);
                    node.setTemplateId(templateId);
                    node.setCreator(userId);
                    node.setModifier(userId);
                    this.nodeMapper.insertSelective(node);
                } else { // old node to update
                    node.setModifier(userId);
                    this.nodeMapper.updateByPrimaryKeySelective(node);
                }

                List<Node> subNodes = node.getSubNodes();
                if (subNodes != null && subNodes.size() > 0) {
                    parentId = node.getId();
                    modifyNodes(subNodes, templateId, userId, parentId);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.itinna.smalltool.service.TemplateService#search(com.itinna.smalltool.
     * web.form.template.SearchTemplateForm)
     */
    @Override
    public SearchTemplateView search(SearchTemplateForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ViewTemplateView view(ViewTemplateForm form) {
        return this.view(form.getTemplateId());
    }

    private ViewTemplateView view(String templateId) {
        if (templateId == null) {
            throw new ServiceException("no template id");
        }
        Template template = this.templateMapper.selectDetailByPrimaryKey(templateId);
        if (template == null) {
            throw new ServiceException("no template");
        }
        ViewTemplateView view = new ViewTemplateView();
        TemplateView templateView = this.getTemplateView(template);
        view.setTemplate(templateView);

        return view;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.itinna.smalltool.service.TemplateService#delete(com.itinna.smalltool.
     * web.form.template.DeleteTemplateForm)
     */
    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean delete(DeleteTemplateForm form) {
        String templateId = form.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            throw new ServiceException("no template id");
        }

        // delete report data
        this.deleteReports(templateId);

        // delete user_template
        this.deleteAdminsAndReporters(templateId);

        // delete node
        this.deleteNodes(templateId);

        // delete template
        this.templateMapper.deleteByPrimaryKey(templateId);

        return true;
    }

    private void deleteReports(String templateId) {
        List<Report> reports = this.reportMapper.selectByTemplateId(templateId);
        if (reports != null && reports.size() > 0) {
            for (Report report : reports) {
                String reportId = report.getId();
                List<ReportValue> values = this.reportValueMapper.selectByReportId(reportId);
                if (values != null && values.size() > 0) {
                    for (ReportValue value : values) {
                        String reportValueId = value.getId();
                        List<Attachment> attachments = this.attachmentMapper.selectByPeportValueId(reportValueId);
                        if (attachments != null && attachments.size() > 0) {
                            for (Attachment attachment : attachments) {
                                String attachmentId = attachment.getId();
                                // delete attachment
                                this.attachmentMapper.deleteByPrimaryKey(attachmentId);
                                // TODO 删除附件
                            }
                        }
                        // delete report_value
                        this.reportValueMapper.deleteByPrimaryKey(reportValueId);
                    }
                }
                // delete report
                this.reportMapper.deleteByPrimaryKey(reportId);
            }
        }
    }

    private void deleteNodes(String templateId) {
        List<Node> nodes = this.nodeMapper.selectByTemplateId(templateId);
        if (nodes != null && nodes.size() > 0) {
            for (Node node : nodes) {
                this.nodeMapper.deleteByPrimaryKey(node.getId());
            }
        }
    }

}
