package com.jlh.demoworkweb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 15:27
 * Description:
 */
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer state;
}
