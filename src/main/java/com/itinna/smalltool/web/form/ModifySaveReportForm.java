/**
 * 
 */
package com.itinna.smalltool.web.form;

import com.itinna.smalltool.dao.model.Report;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月16日 上午11:05:14
 */
public class ModifySaveReportForm extends BaseForm {

    private Long userId;

    private Report report;

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
     * @return the report
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report
     *            the report to set
     */
    public void setReport(Report report) {
        this.report = report;
    }

}
