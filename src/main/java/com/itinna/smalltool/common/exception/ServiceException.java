/**
 * 
 */
package com.itinna.smalltool.common.exception;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:17:06
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
