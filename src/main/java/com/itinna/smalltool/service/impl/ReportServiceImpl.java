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
import com.itinna.smalltool.dao.mapper.UserMapper;
import com.itinna.smalltool.dao.model.Attachment;
import com.itinna.smalltool.dao.model.Node;
import com.itinna.smalltool.dao.model.NodeType;
import com.itinna.smalltool.dao.model.Report;
import com.itinna.smalltool.dao.model.ReportNodeValue;
import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.service.ReportService;
import com.itinna.smalltool.web.form.CreateReportForm;
import com.itinna.smalltool.web.form.DeleteReportForm;
import com.itinna.smalltool.web.form.ModifyReportForm;
import com.itinna.smalltool.web.form.SaveReportForm;
import com.itinna.smalltool.web.form.SearchReportForm;
import com.itinna.smalltool.web.form.SelectReportTypeForm;
import com.itinna.smalltool.web.form.ViewReportForm;
import com.itinna.smalltool.web.vo.CreateReportVO;
import com.itinna.smalltool.web.vo.ModifyReportVO;
import com.itinna.smalltool.web.vo.NodeTypeVO;
import com.itinna.smalltool.web.vo.NodeVO;
import com.itinna.smalltool.web.vo.ReportTypeListVO;
import com.itinna.smalltool.web.vo.ReportTypeVO;
import com.itinna.smalltool.web.vo.SaveReportVO;
import com.itinna.smalltool.web.vo.SearchReportListVO;
import com.itinna.smalltool.web.vo.TemplateVO;
import com.itinna.smalltool.web.vo.ViewReportVO;

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
    private UserMapper userMapper;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private ReportNodeValueMapper reportNodevalueMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public CreateReportVO createReport(CreateReportForm form) {
        Long templateId = form.getTemplateId();
        if (templateId == null) {
            throw new ServiceException("no template id");
        }

        // 获取模版
        Template template = this.templateMapper.select4ReportCreatingByTemplateId(templateId);
        if (template == null) {
            throw new ServiceException("no template");
        }

        TemplateVO templateVO = new TemplateVO();
        templateVO.setTemplateId(templateId);
        templateVO.setTemplateName(template.getTemplateName());
        templateVO.setDesc(template.getDesc());

        List<Node> nodes = template.getNodes();
        if (nodes != null && nodes.size() != 0) {
            List<NodeVO> nodeVOList = new ArrayList<NodeVO>();
            templateVO.setNodes(nodeVOList);

            for (Node node : nodes) {
                NodeVO nodeVO = new NodeVO();
                nodeVOList.add(nodeVO);

                nodeVO.setNodeId(node.getNodeId());
                nodeVO.setNodeName(node.getNodeName());
                nodeVO.setParentId(node.getParentNodeId());
                nodeVO.setPosition(node.getPosition());
                nodeVO.setIsRequired(GeneralConstant.IS_REQUIRED.equals(node.getIsRequired()));

                NodeType nodeType = node.getNodeType();
                if (nodeType != null) {
                    NodeTypeVO nodeTypeVO = new NodeTypeVO();
                    nodeVO.setNodeType(nodeTypeVO);

                    nodeTypeVO.setNodeTypeId(nodeType.getNodeTypeId());
                    nodeTypeVO.setNodeTypeName(nodeType.getNodeTypeName());
                    nodeTypeVO.setDesc(nodeType.getDesc());
                }
            }
        }

        // 设置视图模型对象
        CreateReportVO vo = new CreateReportVO();
        vo.setTemplate(templateVO);

        return vo;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public SaveReportVO saveReport(SaveReportForm form) {
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
        report = this.reportMapper.selectDetailByPK(reportId);
        if (report == null) {
            throw new ServiceException("no report");
        }

        SaveReportVO vo = new SaveReportVO();
        vo.setReport(report);

        return vo;
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
    public SearchReportListVO searchReport(SearchReportForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReportTypeListVO selectType(SelectReportTypeForm form) {
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
        List<ReportTypeVO> reportTypes = new ArrayList<ReportTypeVO>();
        if (templates != null && templates.size() > 0) {
            for (Template template : templates) {
                ReportTypeVO reportType = new ReportTypeVO();
                reportType.setRepportTypeId(template.getTemplateId());
                reportType.setReportTypeName(template.getTemplateName());
                reportType.setDesc(template.getDesc());
                reportTypes.add(reportType);
            }
        }

        // 设置返回值
        ReportTypeListVO vo = new ReportTypeListVO();
        vo.setReportTypes(reportTypes);

        return vo;
    }

    @Override
    public ViewReportVO viewReport(ViewReportForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ModifyReportVO modifyReport(ModifyReportForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteReport(DeleteReportForm form) {
        // TODO Auto-generated method stub
        return false;
    }

}
