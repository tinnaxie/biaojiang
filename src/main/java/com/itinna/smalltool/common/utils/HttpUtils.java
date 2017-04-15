/**
 * 
 */
package com.itinna.smalltool.common.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.itinna.smalltool.web.view.LoginUserView;

/**
 * Http处理工具，注意：此工具仅限于web层使用
 * 
 * @author tinna.xie
 *
 */
public class HttpUtils {

    public static final String LOGIN_USER = "loginUser";

    /**
     * 在session范围内，根据key获取value
     * 
     * @param key
     * @return
     */
    public static Object getSessionAttribute(String key) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getAttribute(key, RequestAttributes.SCOPE_SESSION);
        }
        return null;
    }

    /**
     * 在session范围内，设置key-value
     * 
     * @param key
     * @param value
     */
    public static void setSessionAttribute(String key, Object value) {
        RequestContextHolder.getRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 在session范围内，根据key删除value
     * 
     * @param key
     */
    public static void removeSessionAttribute(String key) {
        RequestContextHolder.getRequestAttributes().removeAttribute(key, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 获取session中的当前登陆用户
     * 
     * @return
     */
    public static LoginUserView getLoginUser() {
        LoginUserView user = null;
        Object loginUser = HttpUtils.getSessionAttribute(LOGIN_USER);
        if (loginUser != null && loginUser instanceof LoginUserView) {
            user = (LoginUserView) loginUser;
        }
        return user;
    }

    /**
     * 将当前登陆用户信息保存在session中
     * 
     * @param user
     */
    public static void setSessionUser(LoginUserView user) {
        setSessionAttribute(LOGIN_USER, user);
    }

    /**
     * 获取session中的当前登陆用户ID
     * 
     * @return
     */
    public static Long getLoginUserId() {
        Long userId = null;
        LoginUserView user = getLoginUser();
        if (user != null) {
            userId = user.getUserId();
        }
        return userId;
    }

    /**
     * 从session中删除当前登陆用户
     */
    public static void removeLoginUser() {
        removeSessionAttribute(LOGIN_USER);
    }

    /**
     * 获取当前的Session ID
     * 
     * @return Session ID
     */
    public static String getSessionId() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getSessionId();
        } else {
            return null;
        }
    }

    /**
     * 获取ServletContext
     * 
     * @param request
     * @return
     */
    public static ServletContext getServletContext(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        return context;
    }

    /**
     * 在session范围内，根据key获取value
     * 
     * @param key
     * @return
     */
    public static Object getRequestAttribute(String key) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getAttribute(key, RequestAttributes.SCOPE_REQUEST);
        }
        return null;
    }

    /**
     * 在session范围内，设置key-value
     * 
     * @param key
     * @param value
     */
    public static void setRequestAttribute(String key, Object value) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            attributes.setAttribute(key, value, RequestAttributes.SCOPE_REQUEST);
        }
    }

}
