/**
 * 
 */
package com.itinna.smalltool.web.form.report;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * 表单对象：查看报表详情
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:50:41
 */
public class ViewReportForm extends BaseForm {

    private Long reportId;

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

}
