package com.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ApiResult<T> implements Serializable {

    private int resCode = 200;
    private String resMsg = "success";
    private T data;

    public static <W> ApiResult<W> SUCCESS(W data) {
        ApiResult<W> result = new ApiResult<>();
        result.setData(data);
        return result;
    }

    public static ApiResult<Object> SUCCESS() {
        ApiResult<Object> result = new ApiResult<>();
        return result;
    }

    public static ApiResult<Object> FAILURE() {
        return FAILURE("fail");
    }

    public static ApiResult<Object> FAILURE(String msg) {
        ApiResult<Object> result = new ApiResult<>();
        result.setResCode(-1);
        result.setResMsg(msg);
        return result;
    }

    public static ApiResult<Object> UNKNOWN() {
        ApiResult<Object> result = new ApiResult<>();
        result.setResCode(100);
        result.setResMsg("未登录或登录失效，请先登录");
        return result;
    }


    public ApiResult(int resCode) {
        this.resCode = resCode;
    }

    public ApiResult(T data) {
        this.data = data;
    }

    public ApiResult() {
    }

    public ApiResult(String resMsg) {
        this.resMsg = resMsg;
    }

    public ApiResult(String resMsg, int resCode) {
        this.resMsg = resMsg;
        this.resCode = resCode;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
