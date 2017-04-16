/**
 * 
 */
package com.itinna.smalltool.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itinna.smalltool.common.constant.GeneralConstant;
import com.itinna.smalltool.common.exception.ServiceException;
import com.itinna.smalltool.common.utils.DateUtils;
import com.itinna.smalltool.common.utils.Pagination;
import com.itinna.smalltool.dao.mapper.AttachmentMapper;
import com.itinna.smalltool.dao.mapper.ReportMapper;
import com.itinna.smalltool.dao.mapper.ReportNodeValueMapper;
import com.itinna.smalltool.dao.mapper.TemplateMapper;
import com.itinna.smalltool.dao.model.Attachment;
import com.itinna.smalltool.dao.model.Node;
import com.itinna.smalltool.dao.model.NodeType;
import com.itinna.smalltool.dao.model.Report;
import com.itinna.smalltool.dao.model.ReportNodeValue;
import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.service.ReportService;
import com.itinna.smalltool.web.form.report.CreateReportForm;
import com.itinna.smalltool.web.form.report.CreateSaveReportForm;
import com.itinna.smalltool.web.form.report.DeleteReportForm;
import com.itinna.smalltool.web.form.report.ModifyReportForm;
import com.itinna.smalltool.web.form.report.ModifySaveReportForm;
import com.itinna.smalltool.web.form.report.SearchReportForm;
import com.itinna.smalltool.web.form.report.SelectReportTypeForm;
import com.itinna.smalltool.web.form.report.ViewReportForm;
import com.itinna.smalltool.web.view.AttachmentView;
import com.itinna.smalltool.web.view.CreateReportView;
import com.itinna.smalltool.web.view.ModifyReportView;
import com.itinna.smalltool.web.view.NodeTypeView;
import com.itinna.smalltool.web.view.NodeView;
import com.itinna.smalltool.web.view.ReportNodeValueView;
import com.itinna.smalltool.web.view.ReportTypeView;
import com.itinna.smalltool.web.view.ReportView;
import com.itinna.smalltool.web.view.SearchReportView;
import com.itinna.smalltool.web.view.SelectReportTypeView;
import com.itinna.smalltool.web.view.TemplateView;
import com.itinna.smalltool.web.view.ViewReportView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月4日 上午12:53:02
 */
@Service
public class ReportServiceImpl extends BaseServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private ReportNodeValueMapper reportNodevalueMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public CreateReportView create(CreateReportForm form) {
        // 获取模版
        Long templateId = form.getTemplateId();
        if (templateId == null) {
            throw new ServiceException("no template id");
        }

        Template template = this.templateMapper.select4ReportCreatingByTemplateId(templateId);
        if (template == null) {
            throw new ServiceException("no template");
        }

        // 设置返回值
        CreateReportView view = new CreateReportView();
        TemplateView templateView = new TemplateView();
        view.setTemplate(templateView);

        templateView.setTemplateId(templateId);
        templateView.setTemplateName(template.getTemplateName());
        templateView.setDesc(template.getDesc());

        List<Node> nodes = template.getNodes();
        if (nodes != null && nodes.size() != 0) {
            List<NodeView> nodeViews = new ArrayList<NodeView>();
            templateView.setNodes(nodeViews);

            for (Node node : nodes) {
                NodeView nodeView = new NodeView();
                nodeViews.add(nodeView);

                nodeView.setNodeId(node.getNodeId());
                nodeView.setNodeName(node.getNodeName());
                nodeView.setParentId(node.getParentNodeId());
                nodeView.setPosition(node.getPosition());
                nodeView.setIsRequired(GeneralConstant.IS_REQUIRED.equals(node.getIsRequired()));

                NodeType nodeType = node.getNodeType();
                if (nodeType != null) {
                    NodeTypeView nodeTypeView = new NodeTypeView();
                    nodeView.setNodeType(nodeTypeView);

                    nodeTypeView.setNodeTypeId(nodeType.getNodeTypeId());
                    nodeTypeView.setNodeTypeName(nodeType.getNodeTypeName());
                    nodeTypeView.setDesc(nodeType.getDesc());
                }
            }
        }

        return view;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ViewReportView createSave(CreateSaveReportForm form) {
        // insert report
        Report report = form.getReport();
        if (report == null) {
            throw new ServiceException("no report");
        }

        long reportId = this.reportMapper.generateId();
        if (reportId == 0) {
            throw new ServiceException("no report id");
        } else {
            report.setReportId(reportId);
        }

        Long userId = form.getUserId();
        if (userId == null) {
            throw new ServiceException("no user");
        } else {
            report.setUserId(userId);
            report.setCreator(userId);
            report.setModifier(userId);
        }
        report.setTemplateId(form.getTemplateId());
        report.setReportName(this.getReportName(form.getTemplateName(), form.getUserName()));
        this.reportMapper.insertSelective(report);

        // insert node values
        List<ReportNodeValue> nodeValues = report.getNodeValues();
        if (nodeValues != null && nodeValues.size() > 0) {
            for (ReportNodeValue nodeValue : nodeValues) {
                long valueId = this.reportNodevalueMapper.generateId();
                nodeValue.setValueId(valueId);
                nodeValue.setReportId(reportId);
                this.reportNodevalueMapper.insert(nodeValue);

                // insert attachment
                List<Attachment> attachments = nodeValue.getAttachments();
                if (attachments != null && attachments.size() > 0) {
                    for (Attachment attachment : attachments) {
                        attachment.setValueId(valueId);
                        long attachmentId = this.attachmentMapper.generateId();
                        attachment.setAttachmentId(attachmentId);
                        attachment.setUrl(this.getAttachmentUrl());
                        this.attachmentMapper.insert(attachment);
                    }
                }
            }
        }

        // select report detail
        report = this.reportMapper.selectDetailByPrimaryKey(reportId);
        if (report == null) {
            throw new ServiceException("no report");
        }

        // set return value
        ViewReportView view = new ViewReportView();
        view.setReport(this.getReportView(report));

        return view;
    }

    private String getAttachmentUrl() {
        // TODO
        return "";
    }

    private String getReportName(String templateName, String userName) {
        if (templateName == null || "".equals(templateName)) {
            throw new ServiceException("no template name");
        }

        if (userName == null || "".equals(userName)) {
            throw new ServiceException("no user name");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(templateName);
        sb.append("-");
        sb.append(userName);
        sb.append("-");
        sb.append(DateUtils.format(new Date(), DateUtils.DATE_FORMATTER_4));
        return sb.toString();
    }

    @Override
    public SearchReportView search(SearchReportForm form) {
        // select reports by condition
        Long userId = form.getUserId();
        if (userId == null) {
            throw new ServiceException("no user");
        }

        int recordCount = this.reportMapper.countByCondition(form);
        int pageSize = 31; // TODO

        Pagination pagination = form.getPagination();
        if (pagination == null) {
            pagination = new Pagination(recordCount, pageSize);
            form.setPagination(pagination);
        } else {
            pagination.setRecordCount(recordCount);
            pagination.setPageSize(pageSize);
            pagination.compute();
        }

        List<Report> reports = this.reportMapper.selectByCondition(form);

        // set return value
        SearchReportView view = new SearchReportView();
        if (reports != null && reports.size() > 0) {
            List<ReportView> reportViews = new ArrayList<ReportView>();
            view.setReports(reportViews);

            for (Report report : reports) {
                ReportView reportView = new ReportView();
                reportViews.add(reportView);

                reportView.setReportId(report.getReportId());
                reportView.setReportName(report.getReportName());
            }
        }
        return view;
    }

    @Override
    public SelectReportTypeView selectType(SelectReportTypeForm form) {
        Long userId = form.getUserId();
        if (userId == null) {
            throw new ServiceException("no user");
        }

        // 查询记录总数
        int recordCount = this.templateMapper.countWritableByUserId(userId);

        // 查询每页显示记录数
        int pageSize = 20; // TODO

        // 设置分页器
        Pagination pagination = form.getPagination();
        if (pagination == null) { // 第一次
            pagination = new Pagination(recordCount, pageSize);
            form.setPagination(pagination);
        } else {
            pagination.setRecordCount(recordCount);
            pagination.setPageSize(pageSize);
            pagination.compute();
        }

        // 查询报表模版
        List<Template> templates = this.templateMapper.selectWritableByUserId(form);
        List<ReportTypeView> reportTypes = new ArrayList<ReportTypeView>();
        if (templates != null && templates.size() > 0) {
            for (Template template : templates) {
                ReportTypeView reportType = new ReportTypeView();
                reportType.setRepportTypeId(template.getTemplateId());
                reportType.setReportTypeName(template.getTemplateName());
                reportType.setDesc(template.getDesc());
                reportTypes.add(reportType);
            }
        }

        // 设置返回值
        SelectReportTypeView vo = new SelectReportTypeView();
        vo.setReportTypes(reportTypes);

        return vo;
    }

    @Override
    public ViewReportView view(ViewReportForm form) {
        // 获取报告
        Report report = this.reportMapper.selectDetailByPrimaryKey(form.getReportId());
        if (report == null) {
            throw new ServiceException("no report");
        }

        // 设置返回值
        ViewReportView view = new ViewReportView();
        view.setReport(this.getReportView(report));

        return view;
    }

    /**
     * 将report详情对象转化为视图
     * 
     * @param report
     * @return
     */
    private ReportView getReportView(Report report) {
        ReportView reportView = new ReportView();
        reportView.setReportId(report.getReportId());
        reportView.setReportName(report.getReportName());

        List<ReportNodeValue> values = report.getNodeValues();
        if (values != null && values.size() > 0) {
            List<ReportNodeValueView> valueViews = new ArrayList<ReportNodeValueView>();
            reportView.setValues(valueViews);
            for (ReportNodeValue value : values) {
                ReportNodeValueView valueView = new ReportNodeValueView();
                valueViews.add(valueView);
                valueView.setValueId(value.getValueId());
                valueView.setValue(value.getValue());

                Node node = value.getNode();
                if (node == null) {
                    throw new ServiceException("no node");
                }
                NodeView nodeView = new NodeView();
                valueView.setNode(nodeView);
                nodeView.setNodeId(node.getNodeId());
                nodeView.setNodeName(node.getNodeName());
                nodeView.setNodeTypeId(node.getNodeTypeId());
                nodeView.setParentId(node.getParentNodeId());
                nodeView.setPosition(node.getPosition());

                List<Attachment> attachments = value.getAttachments();
                if (attachments != null && attachments.size() > 0) {
                    List<AttachmentView> attachmentViews = new ArrayList<AttachmentView>();
                    valueView.setAttachments(attachmentViews);
                    for (Attachment attachment : attachments) {
                        AttachmentView attachmentView = new AttachmentView();
                        attachmentViews.add(attachmentView);
                        attachmentView.setAttachmentId(attachment.getAttachmentId());
                        attachmentView.setTypeId(attachment.getAttachementTypeId());
                        attachmentView.setUrl(attachment.getUrl());
                    }
                }
            }
        }
        return reportView;
    }

    @Override
    public ModifyReportView modify(ModifyReportForm form) {
        // get report detail
        Report report = this.reportMapper.selectDetailByPrimaryKey(form.getReportId());
        if (report == null) {
            throw new ServiceException("no report");
        }

        // set return value
        ReportView reportView = this.getReportView(report);
        ModifyReportView view = new ModifyReportView();
        view.setReport(reportView);
        return view;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ViewReportView modifySave(ModifySaveReportForm form) {
        // update report
        Report report = form.getReport();
        if (report == null) {
            throw new ServiceException("no report");
        }
        report.setModifier(form.getUserId());
        this.reportMapper.updateByPrimaryKeySelective(report);

        // update report_node_value
        List<ReportNodeValue> values = report.getNodeValues();
        if (values != null && values.size() > 0) {
            for (ReportNodeValue value : values) {
                this.reportNodevalueMapper.updateByPrimaryKeySelective(value);

                // update attachment
                List<Attachment> attachments = value.getAttachments();
                if (attachments != null && attachments.size() > 0) {
                    for (Attachment attachment : attachments) {
                        this.attachmentMapper.updateByPrimaryKeySelective(attachment);
                    }
                }
            }
        }

        // set return value
        ViewReportView view = new ViewReportView();
        view.setReport(this.getReportView(report));

        return view;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean delete(DeleteReportForm form) {
        this.reportMapper.deleteByPrimaryKey(form.getReportId());
        return true;
    }

}
