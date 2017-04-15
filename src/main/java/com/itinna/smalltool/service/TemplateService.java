/**
 * 
 */
package com.itinna.smalltool.service;

import com.itinna.smalltool.web.vo.TemplateVO;

/**
 * 模版服务
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午1:17:04
 */
public interface TemplateService extends BaseSerivce {

    public TemplateVO getTemplate(Long templateId);
}
