/**
 * 
 */
package com.itinna.smalltool.web.form.template;

import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.web.form.BaseForm;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月16日 下午3:57:25
 */
public class ModifyTemplateForm extends BaseForm {

    private Template template;

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
