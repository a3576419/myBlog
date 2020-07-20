package com.aioe.test.demo.pojo;

import javax.xml.crypto.Data;
import java.time.Period;

public class BaseBean<T> {
    private T date;
    private Integer code;
    private String msg;

    @Override
    public String toString() {
        return "BaseBean{" +
                "date=" + date +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
