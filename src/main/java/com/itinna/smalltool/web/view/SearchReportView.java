/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * 视图模型对象：查找报表集合
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class SearchReportView extends BaseView {

    private List<ReportView> reports;

    /**
     * @return the reports
     */
    public List<ReportView> getReports() {
        return reports;
    }

    /**
     * @param reports
     *            the reports to set
     */
    public void setReports(List<ReportView> reports) {
        this.reports = reports;
    }

}
