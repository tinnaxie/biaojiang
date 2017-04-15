/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itinna.smalltool.common.exception.ControllerException;
import com.itinna.smalltool.common.utils.HttpUtils;
import com.itinna.smalltool.common.utils.StringUtils;
import com.itinna.smalltool.service.UserService;
import com.itinna.smalltool.web.view.LoginUserView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:04:17
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * 
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        // 验证业务系统用户id
        String bizUserId = this.getBizUserId();
        if (StringUtils.isEmpty(bizUserId)) {
            // 如果业务系统id不存在则发生异常
            throw new ControllerException("no bizUserId");
        }

        // 执行用户登录
        LoginUserView user = this.userService.login(bizUserId);
        if (user == null) {
            throw new ControllerException("no user");
        }
        HttpUtils.setSessionUser(user);

        return "index";
    }

    private String getBizUserId() {
        return "123456";
    }

    @RequestMapping("/logout")
    public String logout() {
        Long userId = HttpUtils.getLoginUserId();
        if (userId != null) {
            HttpUtils.removeLoginUser();
        }
        return "logout";
    }
}
