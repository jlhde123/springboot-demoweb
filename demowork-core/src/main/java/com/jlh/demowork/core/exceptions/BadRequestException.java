package com.jlh.demowork.core.exceptions;

import com.jlh.demowork.core.enums.ServerStatusEnums;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-29 16:23
 * Description: 无效请求--例如参数错误等
 */
public class BadRequestException extends AbstractException{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BadRequestException(String message, String developerMsg) {
        super(message, developerMsg);
    }

    public BadRequestException(String message, Throwable cause, String developerMsg) {
        super(message, cause, developerMsg);
    }

    public BadRequestException(Throwable cause, String developerMsg) {
        super(cause, developerMsg);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String developerMsg) {
        super(message, cause, enableSuppression, writableStackTrace, developerMsg);
    }

    @Override
    public ServerStatusEnums getErrorEnum() {
        return ServerStatusEnums.BadRequest;
    }
}
