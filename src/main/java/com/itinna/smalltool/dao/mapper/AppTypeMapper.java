package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.AppType;

public interface AppTypeMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int deleteByPrimaryKey(Long appTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insert(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insertSelective(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    AppType selectByPrimaryKey(Long appTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKeySelective(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKey(AppType record);
}