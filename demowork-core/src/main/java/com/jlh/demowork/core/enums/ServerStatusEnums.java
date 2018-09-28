package com.jlh.demowork.core.enums;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 10:21
 * Description:
 */
public enum ServerStatusEnums {
    ServerSuccess(200,"请求成功"),
    ServerError(500,"服务器异常");
    private Integer code;
    private String content;

    ServerStatusEnums(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ServerStatusEnums{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
