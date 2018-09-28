package com.jlh.demowork.core.http;

import com.jlh.demowork.core.enums.ServerStatusEnums;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 10:38
 * Description:
 */
@Data
public class HttpResponseDTO<T> {
    private Integer code;
    private String msg;
    private String tip;
    private T data;

    public static HttpResponseDTO<String> success() {
        return success("ok");
    }

    public static <T> HttpResponseDTO<T> success(T data) {
        HttpResponseDTO<T> responseDTO = new HttpResponseDTO<>();
        responseDTO.setCode(ServerStatusEnums.ServerSuccess.getCode());
        responseDTO.setMsg(ServerStatusEnums.ServerSuccess.getContent());
        responseDTO.setTip("");
        responseDTO.setData(data);
        return responseDTO;
    }

    public static <T> HttpResponseDTO<T> build(ServerStatusEnums serverStatusEnums,T data,String tip) {
        HttpResponseDTO<T> responseDTO = new HttpResponseDTO<>();
        responseDTO.setCode(serverStatusEnums.getCode());
        responseDTO.setMsg(serverStatusEnums.getContent());
        responseDTO.setTip(tip);
        responseDTO.setData(data);
        return responseDTO;
    }
}
