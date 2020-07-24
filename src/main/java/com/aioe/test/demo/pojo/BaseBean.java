package com.aioe.test.demo.pojo;

import javax.xml.crypto.Data;
import java.time.Period;

public class BaseBean<T> {
    private T data;
    private Integer code;
    private String msg;

    @Override
    public String toString() {
        return "BaseBean{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
