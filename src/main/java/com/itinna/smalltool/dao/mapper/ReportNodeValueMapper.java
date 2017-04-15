package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.ReportNodeValue;

public interface ReportNodeValueMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int deleteByPrimaryKey(Long valueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insert(ReportNodeValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insertSelective(ReportNodeValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    ReportNodeValue selectByPrimaryKey(Long valueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKeySelective(ReportNodeValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_node_value
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKey(ReportNodeValue record);
}