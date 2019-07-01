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


    @Override
    public ServerStatusEnums getErrorEnum() {
        return ServerStatusEnums.BadRequest;
    }
}
