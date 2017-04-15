/**
 * 
 */
package com.itinna.smalltool.web.form;

import java.util.Date;

/**
 * 表单对象：查找报表
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:50:41
 */
public class SearchReportForm extends BaseForm {

    private Long userId;

    private Long templateId;

    private Long reportUserId;

    private Date date;

    /**
     * @return the reportUserId
     */
    public Long getReportUserId() {
        return reportUserId;
    }

    /**
     * @param reportUserId
     *            the reportUserId to set
     */
    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

}
