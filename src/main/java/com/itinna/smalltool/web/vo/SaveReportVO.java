/**
 * 
 */
package com.itinna.smalltool.web.vo;

import com.itinna.smalltool.dao.model.Report;

/**
 * 视图模型对象：查看报表详情
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class SaveReportVO extends BaseVO {

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
