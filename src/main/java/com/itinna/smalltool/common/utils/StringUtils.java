/**
 * 
 */
package com.itinna.smalltool.common.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 字符串处理工具
 * 
 * @author tinna.xie
 * 
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    private static final String START             = "={";
    private static final String END               = "}";
    public static final String  GET_METHOD_PREFIX = "get";
    public static final String  IS_METHOD_PREFIX  = "is";
    private static final String FIELD_EQUAL_SIGN  = "=";
    private static final String FIELD_SEP         = ", ";
    private static final String METHOD_GET_CLASS  = "getClass";
    public static final String  EMPTY_STRING      = "";

    /**
     * 利用JAVA的反射机制实现Object的toString,将该Object的所有成员变量值依次连接起来
     * 输出格式：User={name=test, userId=1234, userName=null, password=null, }
     * 
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        Class<?> clazz = obj.getClass();
        StringBuilder buffer = new StringBuilder(clazz.getSimpleName()).append(START);

        Method[] methods = clazz.getMethods();
        if (methods != null) {
            for (int i = 0; i < methods.length; i++) {
                String methodName = methods[i].getName();
                if (methodName.startsWith(GET_METHOD_PREFIX)) {
                    if ((methodName.startsWith(GET_METHOD_PREFIX) && !StringUtils.equalsIgnoreCase(methodName,
                            METHOD_GET_CLASS)) || methodName.startsWith(IS_METHOD_PREFIX)) {
                        try {
                            String fieldName = toLowerCase4FirstChar(methods[i].getName().substring(
                                    GET_METHOD_PREFIX.length()));
                            Object value = methods[i].invoke(obj);
                            if (i != 0) {
                                buffer.append(FIELD_SEP);
                            }
                            buffer.append(fieldName).append(FIELD_EQUAL_SIGN).append(value);
                        } catch (Exception e) {
                            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
                        } // end try
                    } // end if
                } // end if
            } // end for method
        }
        buffer.append(END);
        return buffer.toString();
    }

    /**
     * 将字符串的首字母转化为大写字母
     * @param str
     * @return
     */
    public static String toUpperCase4FirstChar(String str) {
        return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * 将字符串的首字母转化为小写字母
     * @param str
     * @return
     */
    public static String toLowerCase4FirstChar(String str) {
        return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static boolean NotEquals(String str1, String str2) {
        return !equals(str1, str2);
    }

    /**
     * 构造getter方法名，即将传入的字符串参数的首字母转化为大写字母，然后加上“get”前缀
     * @param str
     * @return
     */
    public static String constractGetterMethod(String str) {
        return (new StringBuilder()).append(GET_METHOD_PREFIX).append(Character.toUpperCase(str.charAt(0)))
                .append(str.substring(1)).toString();
    }

    public static boolean isEmpty(String str) {
        boolean ret = true;
        if (str != null) {
            str = str.trim();
            ret = "".equals(str);
        }
        return ret;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String sortProp(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    public static String[] split(String str, String separator) {
        String[] ret = null;
        if (isNotEmpty(str) && isNotEmpty(separator)) {
            ret = org.apache.commons.lang.StringUtils.split(str, separator);
        }
        return ret;
    }

    /**
     * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回空字符串<code>""</code>，否则返回字符串本身。
     * 
     * <p>
     * 此方法实际上和<code>defaultIfNull(String)</code>等效。
     * <pre>
     * StringUtil.defaultIfEmpty(null)  = ""
     * StringUtil.defaultIfEmpty("")    = ""
     * StringUtil.defaultIfEmpty("  ")  = "  "
     * StringUtil.defaultIfEmpty("bat") = "bat"
     * </pre>
     * </p>
     *
     * @param str 要转换的字符串
     *
     * @return 字符串本身或空字符串<code>""</code>
     */
    public static String defaultIfEmpty(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    /**
     * 检查字符串中是否包含指定的字符。如果字符串为<code>null</code>，将返回<code>false</code>。
     * <pre>
     * StringUtil.contains(null, *)    = false
     * StringUtil.contains("", *)      = false
     * StringUtil.contains("abc", 'a') = true
     * StringUtil.contains("abc", 'z') = false
     * </pre>
     *
     * @param str 要扫描的字符串
     * @param searchChar 要查找的字符
     *
     * @return 如果找到，则返回<code>true</code>
     */
    public static boolean contains(String str, char searchChar) {
        if ((str == null) || (str.length() == 0)) {
            return false;
        }

        return str.indexOf(searchChar) >= 0;
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(StringUtils.isEmpty(str.trim()));
    }

}
