/**
 * 
 */
package com.itinna.smalltool.web.view;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月15日 下午10:58:01
 */
public class AttachmentView extends BaseView {

    private Long attachmentId;

    private Long typeId;

    private String url;

    /**
     * @return the attachmentId
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId
     *            the attachmentId to set
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * @return the typeId
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     *            the typeId to set
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
