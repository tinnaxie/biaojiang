/**
 * 
 */
package com.itinna.smalltool.web.form.report;

import com.itinna.smalltool.dao.model.Report;
import com.itinna.smalltool.web.form.BaseForm;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月16日 上午11:05:14
 */
public class ModifySaveReportForm extends BaseForm {

    private Report report;

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
