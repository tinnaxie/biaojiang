/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月10日 下午1:34:35
 */
public class NodeView extends BaseView {

    private String id;

    private String parentId;

    private String name;

    private int position;

    private String isRequired;

    private Integer nodeTypeId;

    private NodeTypeView nodeType;

    private String hasAttachment;

    private List<NodeView> subNodes;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the isRequired
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * @param isRequired
     *            the isRequired to set
     */
    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * @return the nodeTypeId
     */
    public Integer getNodeTypeId() {
        return nodeTypeId;
    }

    /**
     * @param nodeTypeId
     *            the nodeTypeId to set
     */
    public void setNodeTypeId(Integer nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
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
     * @return the hasAttachment
     */
    public String getHasAttachment() {
        return hasAttachment;
    }

    /**
     * @param hasAttachment
     *            the hasAttachment to set
     */
    public void setHasAttachment(String hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    /**
     * @return the subNodes
     */
    public List<NodeView> getSubNodes() {
        return subNodes;
    }

    /**
     * @param subNodes
     *            the subNodes to set
     */
    public void setSubNodes(List<NodeView> subNodes) {
        this.subNodes = subNodes;
    }

}
