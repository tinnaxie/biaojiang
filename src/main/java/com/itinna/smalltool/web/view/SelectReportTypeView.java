/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * 视图模型对象：报表类型集合
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class SelectReportTypeView extends BaseView {

    private List<ReportTypeView> reportTypes;

    /**
     * @return the reportTypes
     */
    public List<ReportTypeView> getReportTypes() {
        return reportTypes;
    }

    /**
     * @param reportTypes
     *            the reportTypes to set
     */
    public void setReportTypes(List<ReportTypeView> reportTypes) {
        this.reportTypes = reportTypes;
    }

}
