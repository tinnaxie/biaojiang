/**
 * 
 */
package com.itinna.smalltool.service;

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
 * 报表服务
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:17:04
 */
public interface ReportService extends BaseService {

    /**
     * 显示新建报表
     * 
     * @param CreateReportForm
     * @return CreateReportVO
     */
    public CreateReportView create(CreateReportForm form);

    /**
     * 保存新建的报表
     * 
     * 
     * @param CreateSaveReportForm
     * @return SaveReportVO
     */
    public ViewReportView createSave(CreateSaveReportForm form);

    /**
     * 查找报表
     * 
     * @param SearchReportForm
     * @return SearchReportListVO
     */
    public SearchReportView search(SearchReportForm form);

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
    public ViewReportView view(ViewReportForm form);

    /**
     * 显示被修改报表
     * 
     * @param ModifyReportForm
     * @return ModifyReportVO
     */
    public ModifyReportView modify(ModifyReportForm form);

    /**
     * 保存已修改报表
     * 
     * @param form
     * @return
     */
    public ViewReportView modifySave(ModifySaveReportForm form);

    /**
     * 删除报表
     * 
     * @param DeleteReportForm
     * @return boolean true-成功; false-失败;
     */
    public boolean delete(DeleteReportForm form);
}
