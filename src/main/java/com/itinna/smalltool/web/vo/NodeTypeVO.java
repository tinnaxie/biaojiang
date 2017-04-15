/**
 * 
 */
package com.itinna.smalltool.web.vo;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月10日 下午1:37:05
 */
public class NodeTypeVO extends BaseVO {

    private Long nodeTypeId;

    private String nodeTypeName;

    private String desc;

    /**
     * @return the nodeTypeId
     */
    public Long getNodeTypeId() {
        return nodeTypeId;
    }

    /**
     * @param nodeTypeId
     *            the nodeTypeId to set
     */
    public void setNodeTypeId(Long nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
    }

    /**
     * @return the nodeTypeName
     */
    public String getNodeTypeName() {
        return nodeTypeName;
    }

    /**
     * @param nodeTypeName
     *            the nodeTypeName to set
     */
    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
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

}
