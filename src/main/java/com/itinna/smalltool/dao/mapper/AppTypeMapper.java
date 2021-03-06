package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.AppType;

public interface AppTypeMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insert(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insertSelective(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    AppType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKeySelective(AppType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_type
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKey(AppType record);
}