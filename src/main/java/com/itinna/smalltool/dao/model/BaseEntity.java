/**
 * 
 */
package com.itinna.smalltool.dao.model;

import java.util.UUID;

import com.itinna.smalltool.common.utils.StringUtils;

/**
 * @author tinna.xie
 * 
 */
public abstract class BaseEntity {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return StringUtils.toString(this);
    }

}
