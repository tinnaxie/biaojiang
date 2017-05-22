package com.itinna.smalltool.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itinna.smalltool.web.form.user.LoginForm;
import com.itinna.smalltool.web.view.LoginUserView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring-context.xml", "classpath:/log/log4j.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        LoginUserView view = this.userService.login(this.preLogin());
        System.out.println(view.toString());
        System.out.println("1. login new biaojiang user success");

        this.userService.delete(view.getUserId());
        System.out.println("2. delete user success");
    }

    private LoginForm preLogin() {
        LoginForm form = new LoginForm();
        form.setCellphone("18623143881");
        form.setAppTypeId(1);
        form.setAppUserId("QT123456");
        return form;
    }

}
