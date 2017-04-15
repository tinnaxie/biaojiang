/**
 * 
 */
package com.itinna.smalltool.web.vo;

import java.util.List;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午2:26:33
 */
public class TemplateVO extends BaseVO {

    private Long templateId;

    private String templateName;

    private String desc;

    private List<NodeVO> nodes;

    /**
     * @return the templateId
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     *            the templateId to set
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName
     *            the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     *            the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the nodes
     */
    public List<NodeVO> getNodes() {
        return nodes;
    }

    /**
     * @param nodes
     *            the nodes to set
     */
    public void setNodes(List<NodeVO> nodes) {
        this.nodes = nodes;
    }

}
