/**
 * 
 */
package com.itinna.smalltool.web.view;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月10日 下午1:34:35
 */
public class NodeView extends BaseView {

    private Long nodeId;

    private Long parentId;

    private String nodeName;

    private int position;

    private Boolean isRequired;

    private Long nodeTypeId;

    private NodeTypeView nodeType;

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
     * @return the nodeId
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     *            the nodeId to set
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName
     *            the nodeName to set
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * @return the isRequired
     */
    public Boolean getIsRequired() {
        return isRequired;
    }

    /**
     * @param isRequired
     *            the isRequired to set
     */
    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * @return the nodeType
     */
    public NodeTypeView getNodeType() {
        return nodeType;
    }

    /**
     * @param nodeType
     *            the nodeType to set
     */
    public void setNodeType(NodeTypeView nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
