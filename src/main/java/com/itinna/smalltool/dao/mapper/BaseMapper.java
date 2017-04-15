/**
 * 
 */
package com.itinna.smalltool.dao.mapper;

/**
 * @author tinna.xie
 * 
 */
public interface BaseMapper {

    /**
     * 获取当前插入新记录的id
     * 
     * @return
     */
    long generateId();
}