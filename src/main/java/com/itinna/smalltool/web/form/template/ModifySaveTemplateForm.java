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
 * @date : 2017年4月16日 下午3:57:47
 */
public class ModifySaveTemplateForm extends BaseForm {

    private Template template;

    private List<String> admins;

    private List<String> reporters;

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

    /**
     * @return the admins
     */
    public List<String> getAdmins() {
        return admins;
    }

    /**
     * @param admins
     *            the admins to set
     */
    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    /**
     * @return the reporters
     */
    public List<String> getReporters() {
        return reporters;
    }

    /**
     * @param reporters
     *            the reporters to set
     */
    public void setReporters(List<String> reporters) {
        this.reporters = reporters;
    }

}
