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
import com.itinna.smalltool.service.ReportService;
import com.itinna.smalltool.web.form.report.CreateReportForm;
import com.itinna.smalltool.web.form.report.CreateSaveReportForm;
import com.itinna.smalltool.web.form.report.DeleteReportForm;
import com.itinna.smalltool.web.form.report.ModifyReportForm;
import com.itinna.smalltool.web.form.report.ModifySaveReportForm;
import com.itinna.smalltool.web.form.report.SearchReportForm;
import com.itinna.smalltool.web.form.report.SelectReportTypeForm;
import com.itinna.smalltool.web.form.report.ViewReportForm;
import com.itinna.smalltool.web.view.CreateReportView;
import com.itinna.smalltool.web.view.ModifyReportView;
import com.itinna.smalltool.web.view.SearchReportView;
import com.itinna.smalltool.web.view.SelectReportTypeView;
import com.itinna.smalltool.web.view.ViewReportView;

/**
 * @author tinna
 *
 */
@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/index")
    public String index() {
        return "report/report_index";
    }

    @RequestMapping("/select_type")
    public String selectType(@ModelAttribute("selectReportTypeForm") SelectReportTypeForm form, BindingResult result,
            Model model) {
        // 设置用户id
        form.setLoginUserId(HttpUtils.getLoginUserId());

        // 执行业务
        SelectReportTypeView view = this.reportService.selectType(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_select_type";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("createReportForm") CreateReportForm form, BindingResult result, Model model) {
        // 表单验证

        // 执行业务
        CreateReportView view = this.reportService.create(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_create";
    }

    @RequestMapping("/create/save")
    public String createSave(@ModelAttribute("createSaveReportForm") CreateSaveReportForm form, BindingResult result,
            Model model) {
        // 表单验证
        // TODO

        // 设置用户id
        form.setLoginUserId(HttpUtils.getLoginUserId());

        // 执行业务
        ViewReportView view = this.reportService.createSave(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_view";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("searchReportForm") SearchReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 设置用户id
        form.setLoginUserId(HttpUtils.getLoginUserId());

        // 业务执行
        SearchReportView view = this.reportService.search(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_search";
    }

    @RequestMapping("/view")
    public String view(@ModelAttribute("viewReportForm") ViewReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        ViewReportView view = this.reportService.view(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_view";
    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("modifyReportForm") ModifyReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 业务执行
        ModifyReportView view = this.reportService.modify(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_modify";
    }

    @RequestMapping("/modify/save")
    public String modifySave(@ModelAttribute("modifySaveReportForm") ModifySaveReportForm form, BindingResult result,
            Model model) {
        // 表单验证
        // TODO

        // 获取当前用户id
        form.setLoginUserId(HttpUtils.getLoginUserId());

        // 业务执行
        ViewReportView view = this.reportService.modifySave(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_view";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("deleteReportForm") DeleteReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        boolean view = this.reportService.delete(form);

        // 设置返回数据
        model.addAttribute("resultView", view);

        return "report/report_delete";
    }
}
