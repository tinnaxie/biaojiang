package com.itinna.smalltool.dao.mapper;

import com.itinna.smalltool.dao.model.Configuration;

public interface ConfigurationMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    int deleteByPrimaryKey(Long configId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    int insert(Configuration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    int insertSelective(Configuration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    Configuration selectByPrimaryKey(Long configId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    int updateByPrimaryKeySelective(Configuration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table configuration
     *
     * @mbggenerated Thu Apr 06 12:54:57 CST 2017
     */
    int updateByPrimaryKey(Configuration record);
}