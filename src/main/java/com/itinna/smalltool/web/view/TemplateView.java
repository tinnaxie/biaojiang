/**
 * 
 */
package com.itinna.smalltool.web.view;

import java.util.List;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午2:26:33
 */
public class TemplateView extends BaseView {

    private String id;

    private String name;

    private String description;

    private List<NodeView> nodes;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the nodes
     */
    public List<NodeView> getNodes() {
        return nodes;
    }

    /**
     * @param nodes
     *            the nodes to set
     */
    public void setNodes(List<NodeView> nodes) {
        this.nodes = nodes;
    }

}
