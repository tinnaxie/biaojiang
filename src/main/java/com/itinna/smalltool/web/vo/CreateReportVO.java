/**
 * 
 */
package com.itinna.smalltool.web.vo;

/**
 * 视图模型对象： 新建报表
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:36:53
 */
public class CreateReportVO extends BaseVO {

    private TemplateVO template;

    /**
     * @return the template
     */
    public TemplateVO getTemplate() {
        return template;
    }

    /**
     * @param template
     *            the template to set
     */
    public void setTemplate(TemplateVO template) {
        this.template = template;
    }
}
