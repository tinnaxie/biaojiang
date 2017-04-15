/**
 * 
 */
package com.itinna.smalltool.common.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志输出方面
 * 
 * @author tinna.xie
 *
 */
@Aspect
public class DefaultLoggerAspect {

    public static String MSG_START = "[START] : ";
    public static String MSG_END = "[END] : ";

    /**
     * 切入任意方法
     */
    @Pointcut("execution(* com.itinna.smalltool..*.*(..))")
    private void anyMethod() {
    }

    /**
     * 切入任何一个带有注解@RequestMapping的方法
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void anyRequest() {
    }

    /**
     * 切入任何以Service为后缀名的所有接口方法
     */
    @Pointcut("execution(* com.itinna.smalltool.service.*.*Service.*(..))")
    private void anyService() {
    }

    /**
     * 切入任何以Mapper为后缀名的所有接口方法
     */
    @Pointcut("execution(* com.itinna.smalltool.dao.*.*Mapper.*(..))")
    private void anyMapper() {
    }

    /**
     * <ul>
     * 接收到异常通知后，输出日志
     * <li>切入点包括：
     * <ul>
     * <li>web层的任何request</li>
     * <li>facade层的任何接口方法</li>
     * <li>manager层的任何接口方法</li>
     * <li>dao层的任何接口方法</li>
     * </ul>
     * </li>
     * <li>若异常则输出error级别的日志</li>
     * </ul>
     * 
     * @param point
     *            连接点
     * @param ex
     *            异常
     */
    @AfterThrowing(pointcut = "anyRequest() || anyService() || anyMapper()", throwing = "ex")
    public void afterThrowingAction(JoinPoint point, Exception ex) {
        // 获取输出日志的目标类
        Logger logger = Logger.getLogger(point.getTarget().getClass());

        StringBuilder msg = new StringBuilder();

        // 设置错误信息
        msg.append(ex.getMessage());

        // 设置所调用的方法
        msg.append(LoggerUtils.getMehotdName(point.getSignature().getName(), point.getArgs()));

        // 设置参数信息
        msg.append(LoggerUtils.getArguments(point.getArgs()));

        // 输出日志
        logger.error(msg.toString(), ex);
    }

    /**
     * <ul>
     * 接收到前置通知后，输出日志
     * <li>切入点：任何方法</li>
     * <li>日志格式："[START] : methodName(argumentType, ..) | Arguments :
     * type=value, .. | userId=*******"</li>
     * </ul>
     * 
     * @param point
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    @Before("anyMethod()")
    public void beforeAction(JoinPoint point) throws SecurityException, NoSuchMethodException {
        // 获取输出日志的目标类
        Logger logger = Logger.getLogger(point.getTarget().getClass());

        // 判断该logger的debug级别的日志是否启用
        if (logger.isDebugEnabled()) {
            String methodName = point.getSignature().getName();
            Object[] args = point.getArgs();

            StringBuilder msg = new StringBuilder();
            msg.append(MSG_START);

            // 设置所调用的方法名及参数类型
            msg.append(LoggerUtils.getMehotdName(methodName, args));

            // 设置参数信息
            msg.append(LoggerUtils.getArguments(args));

            // 输出日志
            logger.debug(msg.toString());
        }
    }

    /**
     * <ul>
     * 接收到后置通知后，输出日志
     * <li>切入点：任何方法</li>
     * <li>日志格式："[END] : methodName(argumentType, ..) | userId=*******"</li>
     * </ul>
     * 
     * @param point
     */
    @After("anyMethod()")
    public void afterAction(JoinPoint point) {
        // 获取输出日志的目标类
        Logger logger = Logger.getLogger(point.getTarget().getClass());

        // 判断该logger的debug级别的日志是否启用
        if (logger.isDebugEnabled()) {
            String methodName = point.getSignature().getName();
            Object[] args = point.getArgs();

            StringBuilder msg = new StringBuilder();
            msg.append(MSG_END);

            // 设置所调用的方法名及参数类型
            msg.append(LoggerUtils.getMehotdName(methodName, args));

            // 输出日志
            logger.debug(msg.toString());
        }
    }

}
