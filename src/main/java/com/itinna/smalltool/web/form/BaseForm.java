/**
 * 
 */
package com.itinna.smalltool.web.form;

import com.itinna.smalltool.common.utils.Pagination;

/**
 * @author tinna
 *
 */
public abstract class BaseForm {

    private Pagination pagination;

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
