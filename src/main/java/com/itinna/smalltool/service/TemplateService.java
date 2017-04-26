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

    /**
     * 保存新建的模版
     * 
     * @param form
     * @return
     */
    ViewTemplateView createSave(CreateSaveTemplateForm form);

    /**
     * 修改模版
     * 
     * @param form
     * @return
     */
    ModifyTemplateView modify(ModifyTemplateForm form);

    /**
     * 保存已修改的模版
     * 
     * @param form
     * @return
     */
    ViewTemplateView modifySave(ModifySaveTemplateForm form);

    /**
     * 搜索模版
     * 
     * @param form
     * @return
     */
    SearchTemplateView search(SearchTemplateForm form);

    /**
     * 查看模版详情
     * 
     * @param form
     * @return
     */
    ViewTemplateView view(ViewTemplateForm form);

    /**
     * 删除模版
     * 
     * @param form
     * @return
     */
    boolean delete(DeleteTemplateForm form);

}
