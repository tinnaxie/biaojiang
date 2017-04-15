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

import com.itinna.smalltool.common.exception.ControllerException;
import com.itinna.smalltool.common.utils.HttpUtils;
import com.itinna.smalltool.service.ReportService;
import com.itinna.smalltool.web.form.CreateReportForm;
import com.itinna.smalltool.web.form.DeleteReportForm;
import com.itinna.smalltool.web.form.ModifyReportForm;
import com.itinna.smalltool.web.form.SaveReportForm;
import com.itinna.smalltool.web.form.SearchReportForm;
import com.itinna.smalltool.web.form.SelectReportTypeForm;
import com.itinna.smalltool.web.form.ViewReportForm;
import com.itinna.smalltool.web.vo.CreateReportVO;
import com.itinna.smalltool.web.vo.ModifyReportVO;
import com.itinna.smalltool.web.vo.ReportTypeListVO;
import com.itinna.smalltool.web.vo.SaveReportVO;
import com.itinna.smalltool.web.vo.SearchReportListVO;
import com.itinna.smalltool.web.vo.ViewReportVO;

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
        Long userId = HttpUtils.getLoginUserId();
        if (userId == null) {
            throw new ControllerException("no user");
        }
        form.setUserId(userId);

        // 执行业务
        ReportTypeListVO vo = this.reportService.selectType(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_select_type";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("createReportForm") CreateReportForm form, BindingResult result, Model model) {
        // 表单验证

        // 执行业务
        CreateReportVO vo = this.reportService.createReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_create";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("saveReportForm") SaveReportForm form, BindingResult result, Model model) {
        // 表单验证

        form.setUserId(HttpUtils.getLoginUserId());

        // 执行业务
        SaveReportVO vo = this.reportService.saveReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_view";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("searchReportForm") SearchReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        SearchReportListVO vo = this.reportService.searchReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_search";
    }

    @RequestMapping("/view")
    public String view(@ModelAttribute("viewReportForm") ViewReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        ViewReportVO vo = this.reportService.viewReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_view";
    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("modifyReportForm") ModifyReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        ModifyReportVO vo = this.reportService.modifyReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_modify";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("deleteReportForm") DeleteReportForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO ...

        // 业务执行
        boolean vo = this.reportService.deleteReport(form);

        // 设置返回数据
        model.addAttribute("resultVO", vo);

        return "report/report_delete";
    }
}
