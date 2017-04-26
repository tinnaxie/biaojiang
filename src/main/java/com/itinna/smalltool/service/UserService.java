/**
 * 
 */
package com.itinna.smalltool.service;

import com.itinna.smalltool.web.form.user.LoginForm;
import com.itinna.smalltool.web.view.LoginUserView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:08:42
 */
public interface UserService extends BaseService {

    public LoginUserView login(LoginForm form);

}
