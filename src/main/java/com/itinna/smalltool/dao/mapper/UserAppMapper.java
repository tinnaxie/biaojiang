package com.itinna.smalltool.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itinna.smalltool.dao.model.UserApp;

public interface UserAppMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insert(UserApp record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insertSelective(UserApp record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    UserApp selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKeySelective(UserApp record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user_app
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKey(UserApp record);

    UserApp selectByAppUserIdAndAppTypeId(@Param("appUserId") String appUserId, @Param("appTypeId") Integer appTypeId);

    List<UserApp> selectByUserId(String userId);
}