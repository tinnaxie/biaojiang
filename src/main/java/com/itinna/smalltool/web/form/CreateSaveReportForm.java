/**
 * 
 */
package com.itinna.smalltool.web.form;

import com.itinna.smalltool.dao.model.Report;

/**
 * 表单对象：查看报表详情
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:50:41
 */
public class CreateSaveReportForm extends BaseForm {

    private Long userId;

    private String userName;

    private Long templateId;

    private String templateName;

    private Report report;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName
     *            the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the templateId
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     *            the templateId to set
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the report
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report
     *            the report to set
     */
    public void setReport(Report report) {
        this.report = report;
    }

}
