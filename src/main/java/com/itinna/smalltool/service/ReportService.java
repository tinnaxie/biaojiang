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
import com.itinna.smalltool.web.vo.CreateReportVO;
import com.itinna.smalltool.web.vo.ModifyReportVO;
import com.itinna.smalltool.web.vo.ReportTypeListVO;
import com.itinna.smalltool.web.vo.SaveReportVO;
import com.itinna.smalltool.web.vo.SearchReportListVO;
import com.itinna.smalltool.web.vo.ViewReportVO;

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
    public CreateReportVO createReport(CreateReportForm form);

    /**
     * 保存报表
     * 
     * 
     * @param SaveReportForm
     * @return SaveReportVO
     */
    public SaveReportVO saveReport(SaveReportForm form);

    /**
     * 查找报表
     * 
     * @param SearchReportForm
     * @return SearchReportListVO
     */
    public SearchReportListVO searchReport(SearchReportForm form);

    /**
     * 选择报表类型
     * 
     * @param form
     * @return
     */
    public ReportTypeListVO selectType(SelectReportTypeForm form);

    /**
     * 查看报表详情
     * 
     * @param ViewReportForm
     * @return ViewReportVO
     */
    public ViewReportVO viewReport(ViewReportForm form);

    /**
     * 修改报表
     * 
     * @param ModifyReportForm
     * @return ModifyReportVO
     */
    public ModifyReportVO modifyReport(ModifyReportForm form);

    /**
     * 删除报表
     * 
     * @param DeleteReportForm
     * @return boolean true-成功; false-失败;
     */
    public boolean deleteReport(DeleteReportForm form);
}
