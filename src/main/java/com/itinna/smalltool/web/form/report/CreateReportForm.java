/**
 * 
 */
package com.itinna.smalltool.web.form.report;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * 表单对象：新建报表
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:50:41
 */
public class CreateReportForm extends BaseForm {

    private Long templateId;

    /**
     * @return the templateId
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     *            the templateId to set
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

}
