package com.jlh.demowork.core.config;

import com.jlh.demowork.core.enums.ServerStatusEnums;
import com.jlh.demowork.core.exceptions.AbstractException;
import com.jlh.demowork.core.http.HttpResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 11:10
 * Description: 异常统一处理
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResponseDTO restException(HttpServletRequest request, HttpServletResponse response, Exception ex){
        logger.error("server error",ex);
        return HttpResponseDTO.build(ServerStatusEnums.ServerError,null,null);
    }

    @ExceptionHandler(AbstractException.class)
    @ResponseBody
    public HttpResponseDTO restAbstractException(HttpServletRequest request, HttpServletResponse response, Exception ex){
        AbstractException abstractException = (AbstractException) ex;
        logger.error("server error msg="+abstractException.getErrorEnum().getContent(),ex);
        return HttpResponseDTO.build(abstractException.getErrorEnum(),null,ex.getMessage());
    }

}
