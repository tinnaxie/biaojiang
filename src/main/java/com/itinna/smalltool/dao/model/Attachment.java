package com.itinna.smalltool.dao.model;

import java.util.Date;

public class Attachment extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.report_value_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String reportValueId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.attachment_type_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Integer attachmentTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.name
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.url
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.id
     *
     * @return the value of attachment.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.id
     *
     * @param id the value for attachment.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.report_value_id
     *
     * @return the value of attachment.report_value_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getReportValueId() {
        return reportValueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.report_value_id
     *
     * @param reportValueId the value for attachment.report_value_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setReportValueId(String reportValueId) {
        this.reportValueId = reportValueId == null ? null : reportValueId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.attachment_type_id
     *
     * @return the value of attachment.attachment_type_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Integer getAttachmentTypeId() {
        return attachmentTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.attachment_type_id
     *
     * @param attachmentTypeId the value for attachment.attachment_type_id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setAttachmentTypeId(Integer attachmentTypeId) {
        this.attachmentTypeId = attachmentTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.name
     *
     * @return the value of attachment.name
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.name
     *
     * @param name the value for attachment.name
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.url
     *
     * @return the value of attachment.url
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.url
     *
     * @param url the value for attachment.url
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.creator
     *
     * @return the value of attachment.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.creator
     *
     * @param creator the value for attachment.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.create_time
     *
     * @return the value of attachment.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.create_time
     *
     * @param createTime the value for attachment.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.modifier
     *
     * @return the value of attachment.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.modifier
     *
     * @param modifier the value for attachment.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.modify_time
     *
     * @return the value of attachment.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.modify_time
     *
     * @param modifyTime the value for attachment.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}