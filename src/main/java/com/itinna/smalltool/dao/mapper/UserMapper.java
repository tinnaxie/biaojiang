package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.User;

public interface UserMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     *
     * @mbggenerated Fri Apr 21 15:31:37 CST 2017
     */
    int updateByPrimaryKey(User record);

    User selectByCellphoneNo(String cellphoneNo);
}