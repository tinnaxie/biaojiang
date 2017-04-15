package com.itinna.smalltool.dao.model;

import java.util.Date;

public class AppType extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.app_type_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long appTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.app_type_name
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private String appTypeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.desc
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_type.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.app_type_id
     *
     * @return the value of app_type.app_type_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getAppTypeId() {
        return appTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.app_type_id
     *
     * @param appTypeId the value for app_type.app_type_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setAppTypeId(Long appTypeId) {
        this.appTypeId = appTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.app_type_name
     *
     * @return the value of app_type.app_type_name
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public String getAppTypeName() {
        return appTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.app_type_name
     *
     * @param appTypeName the value for app_type.app_type_name
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName == null ? null : appTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.desc
     *
     * @return the value of app_type.desc
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.desc
     *
     * @param desc the value for app_type.desc
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.creator
     *
     * @return the value of app_type.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.creator
     *
     * @param creator the value for app_type.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.create_time
     *
     * @return the value of app_type.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.create_time
     *
     * @param createTime the value for app_type.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.modifier
     *
     * @return the value of app_type.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.modifier
     *
     * @param modifier the value for app_type.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_type.modify_time
     *
     * @return the value of app_type.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_type.modify_time
     *
     * @param modifyTime the value for app_type.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}