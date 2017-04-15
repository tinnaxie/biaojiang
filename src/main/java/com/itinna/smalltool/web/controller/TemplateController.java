/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tinna
 *
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        return "template/template_index";
    }

    @RequestMapping("/create")
    public String create() {
        return "template/template_create";
    }

    @RequestMapping("/save")
    public String save() {
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

    @RequestMapping("/delete")
    public String delete() {
        return "template/template_delete";
    }
}
