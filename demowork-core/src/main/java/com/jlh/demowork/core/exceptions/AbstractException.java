package com.jlh.demowork.core.exceptions;

import com.jlh.demowork.core.enums.ServerStatusEnums;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 10:20
 * Description:
 */
@Data
public abstract class AbstractException extends RuntimeException {

    /**
     * 开发者错误信息
     */
    private String developerMsg;

    public AbstractException() {
    }

    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractException(Throwable cause) {
        super(cause);
    }

    public AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AbstractException(String message, String developerMsg) {
        super(message);
        this.developerMsg = developerMsg;
    }

    public AbstractException(String message, Throwable cause, String developerMsg) {
        super(message, cause);
        this.developerMsg = developerMsg;
    }

    public AbstractException(Throwable cause, String developerMsg) {
        super(cause);
        this.developerMsg = developerMsg;
    }

    public AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String developerMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.developerMsg = developerMsg;
    }

    public abstract ServerStatusEnums getErrorEnum();
}
