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

    public AbstractException withDeveloperMsg(String developerMsg){
        this.developerMsg = developerMsg;
        return this;
    }

    public abstract ServerStatusEnums getErrorEnum();
}
