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

import com.itinna.smalltool.service.TemplateService;
import com.itinna.smalltool.web.form.template.CreateSaveTemplateForm;
import com.itinna.smalltool.web.form.template.CreateTemplateForm;

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
        // 表单验证
        // TODO

        return "template/template_create";
    }

    @RequestMapping("/create/save")
    public String createSave(@ModelAttribute("createSaveTemplateForm") CreateSaveTemplateForm form,
            BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 执行业务

        return "template/template_view";
    }

    @RequestMapping("/search")
    public String search() {
        return "template/template_search";
    }

    @RequestMapping("/view")
    public String view() {
        return "template/template_view";
    }

    @RequestMapping("/modify")
    public String modify() {
        return "template/template_modify";
    }

    @RequestMapping("/modify/save")
    public String modifySave() {
        return "template/template_view";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "template/template_delete";
    }
}
