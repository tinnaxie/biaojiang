/**
 * 
 */
package com.itinna.smalltool.web.vo;

/**
 * 
 * 报表类型视图模型对象
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:42:45
 */
public class ReportTypeVO extends BaseVO {

    private Long repportTypeId;

    private String reportTypeName;

    private String desc;

    /**
     * @return the repportTypeId
     */
    public Long getRepportTypeId() {
        return repportTypeId;
    }

    /**
     * @param repportTypeId
     *            the repportTypeId to set
     */
    public void setRepportTypeId(Long repportTypeId) {
        this.repportTypeId = repportTypeId;
    }

    /**
     * @return the reportTypeName
     */
    public String getReportTypeName() {
        return reportTypeName;
    }

    /**
     * @param reportTypeName
     *            the reportTypeName to set
     */
    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     *            the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
