/**
 * 
 */
package com.itinna.smalltool.web.form.report;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * 表单对象：删除报表
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:50:41
 */
public class DeleteReportForm extends BaseForm {

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
