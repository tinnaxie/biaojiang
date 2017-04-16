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
 * @date : 2017年4月16日 下午3:33:46
 */
public class CreateSaveTemplateForm extends BaseForm {

    private Long userId;

    private Template template;

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
