package com.itinna.smalltool.dao.mapper;

import java.util.List;

import com.itinna.smalltool.dao.model.Node;

public interface NodeMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insert(Node record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insertSelective(Node record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    Node selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKeySelective(Node record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table node
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKey(Node record);

    List<Node> selectByTemplateId(String templateId);

    List<Node> selectByParentId(String parentId);
}