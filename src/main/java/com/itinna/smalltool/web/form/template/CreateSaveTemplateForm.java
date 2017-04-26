/**
 * 
 */
package com.itinna.smalltool.web.form.template;

import java.util.List;

import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.web.form.BaseForm;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月16日 下午3:33:46
 */
public class CreateSaveTemplateForm extends BaseForm {

    private Template template;

    private List<String> adminIds;

    private List<String> reporterIds;

    /**
     * @return the adminIds
     */
    public List<String> getAdminIds() {
        return adminIds;
    }

    /**
     * @param adminIds
     *            the adminIds to set
     */
    public void setAdminIds(List<String> adminIds) {
        this.adminIds = adminIds;
    }

    /**
     * @return the reporterIds
     */
    public List<String> getReporterIds() {
        return reporterIds;
    }

    /**
     * @param reporterIds
     *            the reporterIds to set
     */
    public void setReporterIds(List<String> reporterIds) {
        this.reporterIds = reporterIds;
    }

    /**
     * @return the template
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * @param template
     *            the template to set
     */
    public void setTemplate(Template template) {
        this.template = template;
    }

}
