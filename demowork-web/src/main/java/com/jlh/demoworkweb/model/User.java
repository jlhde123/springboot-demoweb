package com.jlh.demoworkweb.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 15:27
 * Description:
 */
@Data
public class User {
    private Long id;
    private String userAccount;
    private String passwd;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer state;
}
