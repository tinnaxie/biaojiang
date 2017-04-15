/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月15日 下午10:04:44
 */
public class ReportView extends BaseView {

    private Long reportId;

    private String reportName;

    private List<ReportNodeValueView> values;

    /**
     * @return the reportId
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     *            the reportId to set
     */
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * @return the reportName
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * @param reportName
     *            the reportName to set
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * @return the values
     */
    public List<ReportNodeValueView> getValues() {
        return values;
    }

    /**
     * @param values
     *            the values to set
     */
    public void setValues(List<ReportNodeValueView> values) {
        this.values = values;
    }

}
