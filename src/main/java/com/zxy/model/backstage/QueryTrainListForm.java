package com.zxy.model.backstage;

import lombok.Data;

import java.util.Date;

@Data
public class QueryTrainListForm {
    private Long pageSize;
    private Long currentPage;
}
