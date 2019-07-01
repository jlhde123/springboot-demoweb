package com.jlh.demowork.core.exceptions;

import com.jlh.demowork.core.enums.ServerStatusEnums;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-29 16:20
 * Description: 未授权访问异常
 */
public class UnAuthorizedException extends AbstractException{
    public UnAuthorizedException() {
    }

    public UnAuthorizedException(String message) {
        super(message);
    }

    public UnAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthorizedException(Throwable cause) {
        super(cause);
    }

    @Override
    public ServerStatusEnums getErrorEnum() {
        return ServerStatusEnums.UnAuthorized;
    }
}
