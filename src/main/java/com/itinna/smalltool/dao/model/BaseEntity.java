/**
 * 
 */
package com.itinna.smalltool.dao.model;

import com.itinna.smalltool.common.utils.StringUtils;

/**
 * @author tinna.xie
 * 
 */
public abstract class BaseEntity {

    @Override
    public String toString() {
        return StringUtils.toString(this);
    }

}
