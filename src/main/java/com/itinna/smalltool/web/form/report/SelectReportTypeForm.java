/**
 * 
 */
package com.itinna.smalltool.web.form.report;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月7日 上午9:01:11
 */
public class SelectReportTypeForm extends BaseForm {

    private Long userId;

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

}
