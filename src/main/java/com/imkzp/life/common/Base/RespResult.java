package com.imkzp.life.common.Base;

import lombok.Data;

@Data
public class RespResult<T> {
    private Integer code;
    private String msg;
    private T data;
}
