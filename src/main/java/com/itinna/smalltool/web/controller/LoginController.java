/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itinna.smalltool.common.exception.ControllerException;
import com.itinna.smalltool.common.utils.HttpUtils;
import com.itinna.smalltool.common.utils.StringUtils;
import com.itinna.smalltool.service.UserService;
import com.itinna.smalltool.web.form.user.LoginForm;
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
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @RequestMapping("/login/submit")
    public String loginSubmit(@ModelAttribute("loginForm") LoginForm form, BindingResult result, Model model) {
        // 表单验证
        // TODO

        // 执行用户登录
        LoginUserView user = this.userService.login(form);
        if (user == null) {
            throw new ControllerException("no user");
        }
        HttpUtils.setSessionUser(user);

        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        String userId = HttpUtils.getLoginUserId();
        if (StringUtils.isNotEmpty(userId)) {
            HttpUtils.removeLoginUser();
        }
        return "/logout";
    }
}
