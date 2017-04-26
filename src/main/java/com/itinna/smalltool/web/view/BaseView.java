/**
 * 
 */
package com.itinna.smalltool.web.view;

import com.itinna.smalltool.common.utils.Pagination;
import com.itinna.smalltool.common.utils.StringUtils;

/**
 * 视图模型对象基类
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:35:50
 */
public abstract class BaseView {

    private Pagination pagination;

    @Override
    public String toString() {
        return StringUtils.toString(this);
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
