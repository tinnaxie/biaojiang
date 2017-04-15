package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.UserApp;

public interface UserAppMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int deleteByPrimaryKey(Long userAppId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insert(UserApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int insertSelective(UserApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    UserApp selectByPrimaryKey(Long userAppId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKeySelective(UserApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_app
     *
     * @mbggenerated Tue Apr 04 19:01:32 CST 2017
     */
    int updateByPrimaryKey(UserApp record);
}