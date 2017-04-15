/**
 * 
 */
package com.itinna.smalltool.service;

import com.itinna.smalltool.web.form.CreateReportForm;
import com.itinna.smalltool.web.form.DeleteReportForm;
import com.itinna.smalltool.web.form.ModifyReportForm;
import com.itinna.smalltool.web.form.SaveReportForm;
import com.itinna.smalltool.web.form.SearchReportForm;
import com.itinna.smalltool.web.form.SelectReportTypeForm;
import com.itinna.smalltool.web.form.ViewReportForm;
import com.itinna.smalltool.web.view.CreateReportView;
import com.itinna.smalltool.web.view.ModifyReportView;
import com.itinna.smalltool.web.view.SelectReportTypeView;
import com.itinna.smalltool.web.view.SaveReportView;
import com.itinna.smalltool.web.view.SearchReportView;
import com.itinna.smalltool.web.view.ViewReportView;

/**
 * 报表服务
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:17:04
 */
public interface ReportService extends BaseSerivce {

    /**
     * 新建报表
     * 
     * @param CreateReportForm
     * @return CreateReportVO
     */
    public CreateReportView createReport(CreateReportForm form);

    /**
     * 保存报表
     * 
     * 
     * @param SaveReportForm
     * @return SaveReportVO
     */
    public SaveReportView saveReport(SaveReportForm form);

    /**
     * 查找报表
     * 
     * @param SearchReportForm
     * @return SearchReportListVO
     */
    public SearchReportView searchReport(SearchReportForm form);

    /**
     * 选择报表类型
     * 
     * @param form
     * @return
     */
    public SelectReportTypeView selectType(SelectReportTypeForm form);

    /**
     * 查看报表详情
     * 
     * @param ViewReportForm
     * @return ViewReportVO
     */
    public ViewReportView viewReport(ViewReportForm form);

    /**
     * 修改报表
     * 
     * @param ModifyReportForm
     * @return ModifyReportVO
     */
    public ModifyReportView modifyReport(ModifyReportForm form);

    /**
     * 删除报表
     * 
     * @param DeleteReportForm
     * @return boolean true-成功; false-失败;
     */
    public boolean deleteReport(DeleteReportForm form);
}
