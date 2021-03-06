package com.jlh.demowork.core.exceptions;

import com.jlh.demowork.core.enums.ServerStatusEnums;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 10:26
 * Description: 基础服务器异常
 */
public class ServerException extends AbstractException {

    public ServerException() {
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

    public ServerStatusEnums getErrorEnum() {
        return ServerStatusEnums.ServerError;
    }
}
