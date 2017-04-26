/**
 * 
 */
package com.itinna.smalltool.service;

import java.util.List;

import com.itinna.smalltool.web.form.user.LoginForm;
import com.itinna.smalltool.web.view.LoginUserView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:08:42
 */
public interface UserService extends BaseService {

    LoginUserView login(LoginForm form);

    boolean delete(String userId);

    boolean delete(List<String> userIds);

}
