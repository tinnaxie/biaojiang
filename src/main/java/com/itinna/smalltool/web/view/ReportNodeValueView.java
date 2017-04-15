/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月15日 下午10:54:05
 */
public class ReportNodeValueView extends BaseView {

    private Long valueId;

    private String value;

    private NodeView node;

    private List<AttachmentView> attachments;

    /**
     * @return the valueId
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * @param valueId
     *            the valueId to set
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the node
     */
    public NodeView getNode() {
        return node;
    }

    /**
     * @param node
     *            the node to set
     */
    public void setNode(NodeView node) {
        this.node = node;
    }

    /**
     * @return the attachments
     */
    public List<AttachmentView> getAttachments() {
        return attachments;
    }

    /**
     * @param attachments
     *            the attachments to set
     */
    public void setAttachments(List<AttachmentView> attachments) {
        this.attachments = attachments;
    }

}
