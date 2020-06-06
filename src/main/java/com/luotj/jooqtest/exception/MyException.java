package com.luotj.jooqtest.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

/**
 * @author create by luotj
 * @Date: 2020/6/4 2:19 下午
 **/
public class MyException extends RuntimeException {

    private int code;
    private String msg;

    public MyException(String message){
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
        this.msg = message;
    }

}
