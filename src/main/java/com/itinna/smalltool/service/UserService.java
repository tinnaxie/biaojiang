/**
 * 
 */
package com.itinna.smalltool.service;

import com.itinna.smalltool.web.view.LoginUserView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:08:42
 */
public interface UserService extends BaseSerivce {

    public Long getUserIdByBizUserId(String bizUserId);

    public Long createNewUser(String bizUserId);

    public LoginUserView getUser(Long userId);

    public LoginUserView login(String bizUserId);

}
