/**
 * 
 */
package com.itinna.smalltool.common.logger;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.itinna.smalltool.web.form.BaseForm;

/**
 * @author tinna.xie
 *
 */
public class LoggerUtils {

    /**
     * <p>
     * 获取方法名及参数类型
     * </p>
     * <p>
     * 输出格式：" | methodName(argumentType, ..)"
     * </p>
     * 
     * @param methodName
     * @param args
     * @return
     */
    public static StringBuilder getMehotdName(String methodName, Object[] args) {
        StringBuilder buffer = new StringBuilder();
        if (StringUtils.isNotEmpty(methodName)) {
            buffer.append(" | ").append(methodName).append("(");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] != null) {
                        if (i != 0) {
                            buffer.append(", ");
                        }
                        buffer.append(args[i].getClass().getSimpleName());
                    }
                }
            }
            buffer.append(")");
        }
        return buffer;
    }

    /**
     * <p>
     * 获取参数值
     * </p>
     * <p>
     * 输出格式：" | Arguments : argumentType=argumentValue, .."
     * </p>
     * 
     * @param args
     * @return
     */
    public static StringBuilder getArguments(Object[] args) {
        StringBuilder buffer = new StringBuilder();
        if (args != null) {
            buffer.append(" | ").append("Arguments : ");
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    if (!(args[i] instanceof Model) && !(args[i] instanceof Locale)
                            && !(args[i] instanceof BindingResult) && !(args[i] instanceof HttpServletRequest)
                            && !(args[i] instanceof HttpServletResponse)) {
                        if (i != 0) {
                            buffer.append(", ");
                        }

                        if (!(args[i] instanceof BaseForm)) {
                            buffer.append(args[i].getClass().getSimpleName()).append("=");
                        }
                        buffer.append(args[i]);
                    }
                }
            }
        }
        return buffer;
    }

}
