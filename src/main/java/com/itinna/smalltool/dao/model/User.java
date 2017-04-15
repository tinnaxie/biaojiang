package com.itinna.smalltool.dao.model;

import java.util.Date;
import java.util.List;

public class User extends BaseEntity {

    private List<UserApp> apps;

    private List<Report> reports;

    private List<UserTemplate> userTemplates;

    /**
     * @return the apps
     */
    public List<UserApp> getApps() {
        return apps;
    }

    /**
     * @param apps
     *            the apps to set
     */
    public void setApps(List<UserApp> apps) {
        this.apps = apps;
    }

    /**
     * @return the reports
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * @param reports
     *            the reports to set
     */
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    /**
     * @return the userTemplates
     */
    public List<UserTemplate> getUserTemplates() {
        return userTemplates;
    }

    /**
     * @param userTemplates
     *            the userTemplates to set
     */
    public void setUserTemplates(List<UserTemplate> userTemplates) {
        this.userTemplates = userTemplates;
    }

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.user_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.cellphone_no
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private String cellphoneNo;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.password
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Long modifier;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column user.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.user_id
     *
     * @param userId
     *            the value for user.user_id
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.cellphone_no
     *
     * @return the value of user.cellphone_no
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.cellphone_no
     *
     * @param cellphoneNo
     *            the value for user.cellphone_no
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo == null ? null : cellphoneNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.password
     *
     * @param password
     *            the value for user.password
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.creator
     *
     * @return the value of user.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.creator
     *
     * @param creator
     *            the value for user.creator
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.create_time
     *
     * @param createTime
     *            the value for user.create_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.modifier
     *
     * @return the value of user.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.modifier
     *
     * @param modifier
     *            the value for user.modifier
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column user.modify_time
     *
     * @return the value of user.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column user.modify_time
     *
     * @param modifyTime
     *            the value for user.modify_time
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}