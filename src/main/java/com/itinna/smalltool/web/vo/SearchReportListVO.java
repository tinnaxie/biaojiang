/**
 * 
 */
package com.itinna.smalltool.web.vo;

import java.util.List;

/**
 * 视图模型对象：查找报表集合
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class SearchReportListVO extends BaseVO {

    private List<Report> reportList;

    /**
     * @return the reportList
     */
    public List<Report> getReportList() {
        return reportList;
    }

    /**
     * @param reportList
     *            the reportList to set
     */
    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    /**
     * 视图模型对象：报表
     *
     * @author tinna.xie
     * @date : 2017年4月2日 下午1:36:53
     */
    public class Report extends BaseVO {

    }
}
