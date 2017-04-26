/**
 * 
 */
package com.itinna.smalltool.web.form;

import com.itinna.smalltool.common.utils.Pagination;
import com.itinna.smalltool.common.utils.StringUtils;

/**
 * @author tinna
 *
 */
public abstract class BaseForm {

    private String userId;

    private Pagination pagination;

    @Override
    public String toString() {
        return StringUtils.toString(this);
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination
     *            the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
