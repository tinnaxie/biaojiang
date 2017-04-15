/**
 * 
 */
package com.itinna.smalltool.common.exception;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月2日 下午3:16:44
 */
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ControllerException() {
        super();
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
