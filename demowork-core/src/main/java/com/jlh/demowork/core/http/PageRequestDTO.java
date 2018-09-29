package com.jlh.demowork.core.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-29 15:43
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO  {
    private Integer pageNum;
    private Integer pageSize;
    private String orderBy;
    private Boolean countSql=true;

}
