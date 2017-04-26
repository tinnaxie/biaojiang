/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itinna.smalltool.common.utils.HttpUtils;
import com.itinna.smalltool.service.TemplateService;
import com.itinna.smalltool.web.form.template.CreateSaveTemplateForm;
import com.itinna.smalltool.web.form.template.CreateTemplateForm;
import com.itinna.smalltool.web.form.template.DeleteTemplateForm;
import com.itinna.smalltool.web.form.template.ModifySaveTemplateForm;
import com.itinna.smalltool.web.form.template.ModifyTemplateForm;
import com.itinna.smalltool.web.form.template.SearchTemplateForm;
import com.itinna.smalltool.web.form.template.ViewTemplateForm;
import com.itinna.smalltool.web.view.ModifyTemplateView;
import com.itinna.smalltool.web.view.SearchTemplateView;
import com.itinna.smalltool.web.view.ViewTemplateView;

/**
 * @author tinna
 *
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    @Autowired
    private TemplateService templateService;

    @RequestMapping("/index")
    public String index() {
        return "template/template_index";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("createTemplateForm") CreateTemplateForm form, BindingResult result,
            Model model) {
        return "template/template_create";
    }

    @RequestMapping("/create/save")
    public String createSave(@ModelAttribute("createSaveTemplateForm") CreateSaveTemplateForm form,
            BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 执行业务
        form.setUserId(HttpUtils.getLoginUserId());
        ViewTemplateView view = this.templateService.createSave(form);

        model.addAttribute("resultView", view);

        return "template/template_view";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("searchTemplateForm") SearchTemplateForm form, BindingResult result,
            Model model) {
        // 表单验证
        // TODO

        // 执行业务
        form.setUserId(HttpUtils.getLoginUserId());
        SearchTemplateView view = this.templateService.search(form);

        model.addAttribute("resultView", view);

        return "template/template_search";
    }

    @RequestMapping("/view")
    public String view(@ModelAttribute("viewTemplateForm") ViewTemplateForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 执行业务
        ViewTemplateView view = this.templateService.view(form);

        model.addAttribute("resultView", view);

        return "template/template_view";
    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("modifyTemplateForm") ModifyTemplateForm form, BindingResult result,
            Model model) {
        // 表单验证
        // TODO

        // 执行业务
        ModifyTemplateView view = this.templateService.modify(form);

        model.addAttribute("resultView", view);

        return "template/template_modify";
    }

    @RequestMapping("/modify/save")
    public String modifySave(@ModelAttribute("modifySaveTemplateForm") ModifySaveTemplateForm form,
            BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 执行业务
        form.setUserId(HttpUtils.getLoginUserId());
        ViewTemplateView view = this.templateService.modifySave(form);

        model.addAttribute("resultView", view);

        return "template/template_view";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("deleteTemplateForm") DeleteTemplateForm form, BindingResult result,
            Model model) {
        // 表单验证
        // TODO

        // 执行业务
        form.setUserId(HttpUtils.getLoginUserId());
        boolean view = this.templateService.delete(form);

        model.addAttribute("resultView", view);
        return "template/template_delete";
    }
}
