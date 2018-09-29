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

    public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServerException(String message, String developerMsg) {
        super(message, developerMsg);
    }

    public ServerException(String message, Throwable cause, String developerMsg) {
        super(message, cause, developerMsg);
    }

    public ServerException(Throwable cause, String developerMsg) {
        super(cause, developerMsg);
    }

    public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String developerMsg) {
        super(message, cause, enableSuppression, writableStackTrace, developerMsg);
    }

    public ServerStatusEnums getErrorEnum() {
        return ServerStatusEnums.ServerError;
    }
}
