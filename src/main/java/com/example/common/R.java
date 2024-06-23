package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(T object){
        R<T> r = new R<>();
        r.data = object;
        r.code = 1;
        r.msg = "成功";
        return r;
    }

    public static <T> R<T> success(){
        R<T> r = new R<>();
        r.data = null;
        r.code = 1;
        r.msg = "成功";
        return r;
    }

    public static <T> R<T> error(T object){
        R<T> r = new R<>();
        r.data = object;
        r.code = 0;
        r.msg = "失败";
        return r;
    }

    public static <T> R<T> error(){
        R<T> r = new R<>();
        r.data = null;
        r.code = 0;
        r.msg = "失败";
        return r;
    }
}
