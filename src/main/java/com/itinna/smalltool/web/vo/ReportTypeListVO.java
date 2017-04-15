/**
 * 
 */
package com.itinna.smalltool.web.vo;

import java.util.List;

/**
 * 视图模型对象：报表类型集合
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class ReportTypeListVO extends BaseVO {

    private List<ReportTypeVO> reportTypes;

    /**
     * @return the reportTypes
     */
    public List<ReportTypeVO> getReportTypes() {
        return reportTypes;
    }

    /**
     * @param reportTypes
     *            the reportTypes to set
     */
    public void setReportTypes(List<ReportTypeVO> reportTypes) {
        this.reportTypes = reportTypes;
    }

}
