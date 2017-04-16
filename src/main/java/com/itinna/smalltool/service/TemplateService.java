/**
 * 
 */
package com.itinna.smalltool.service;

import com.itinna.smalltool.web.form.template.CreateSaveTemplateForm;
import com.itinna.smalltool.web.form.template.DeleteTemplateForm;
import com.itinna.smalltool.web.form.template.ModifySaveTemplateForm;
import com.itinna.smalltool.web.form.template.ModifyTemplateForm;
import com.itinna.smalltool.web.form.template.SearchTemplateForm;
import com.itinna.smalltool.web.form.template.ViewTemplateForm;
import com.itinna.smalltool.web.view.DeleteTemplateView;
import com.itinna.smalltool.web.view.ModifyTemplateView;
import com.itinna.smalltool.web.view.SearchTemplateView;
import com.itinna.smalltool.web.view.ViewTemplateView;

/**
 * 模版服务
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:17:04
 */
public interface TemplateService extends BaseService {

    ViewTemplateView createSave(CreateSaveTemplateForm form);

    ModifyTemplateView modify(ModifyTemplateForm form);

    ViewTemplateView modifySave(ModifySaveTemplateForm form);

    SearchTemplateView search(SearchTemplateForm form);

    ViewTemplateView view(ViewTemplateForm form);

    DeleteTemplateView delete(DeleteTemplateForm form);

}
