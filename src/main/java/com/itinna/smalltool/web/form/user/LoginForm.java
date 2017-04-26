/**
 * 
 */
package com.itinna.smalltool.web.form.user;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月26日 下午2:10:37
 */
public class LoginForm extends BaseForm {

    private String appUserId;

    private Integer appTypeId;

    private String cellphoneNo;

    /**
     * @return the appUserId
     */
    public String getAppUserId() {
        return appUserId;
    }

    /**
     * @param appUserId
     *            the appUserId to set
     */
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * @return the appTypeId
     */
    public Integer getAppTypeId() {
        return appTypeId;
    }

    /**
     * @param appTypeId
     *            the appTypeId to set
     */
    public void setAppTypeId(Integer appTypeId) {
        this.appTypeId = appTypeId;
    }

    /**
     * @return the cellphoneNo
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }

    /**
     * @param cellphoneNo
     *            the cellphoneNo to set
     */
    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }
}
