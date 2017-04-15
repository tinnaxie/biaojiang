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

    private Date date;

    private String startTime;

    private String endTime;

    /**
     * @return the startTime
     */
    public String getStartTime() {
        // TODO
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        // TODO
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

}
