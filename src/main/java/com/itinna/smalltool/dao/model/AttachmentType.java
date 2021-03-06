package com.itinna.smalltool.dao.model;

import java.util.Date;

public class AttachmentType extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.description
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment_type.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.id
     *
     * @return the value of attachment_type.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.id
     *
     * @param id the value for attachment_type.id
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.type
     *
     * @return the value of attachment_type.type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.type
     *
     * @param type the value for attachment_type.type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.description
     *
     * @return the value of attachment_type.description
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.description
     *
     * @param description the value for attachment_type.description
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.creator
     *
     * @return the value of attachment_type.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.creator
     *
     * @param creator the value for attachment_type.creator
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.create_time
     *
     * @return the value of attachment_type.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.create_time
     *
     * @param createTime the value for attachment_type.create_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.modifier
     *
     * @return the value of attachment_type.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.modifier
     *
     * @param modifier the value for attachment_type.modifier
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment_type.modify_time
     *
     * @return the value of attachment_type.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment_type.modify_time
     *
     * @param modifyTime the value for attachment_type.modify_time
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}