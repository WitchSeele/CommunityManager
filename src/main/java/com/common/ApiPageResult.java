package com.common;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ApiPageResult<T> extends ApiResult<T> {

    private int resCode = 200;
    private long counts;
    private int totalpage;
    private int page;
    private int pagesize = 20;
    private String resMsg = "success";
    private T data;

    public static <W> ApiPageResult<W> SUCCESS(W data) {
        ApiPageResult<W> result = new ApiPageResult<>();
        result.setData(data);
        return result;
    }

    public static <W> ApiPageResult<W> SUCCESS(W data, int page, int pagesize, long counts, int totalpage) {
        ApiPageResult<W> result = new ApiPageResult<>();
        result.setData(data);
        result.setCounts(counts);
        result.setPage(page);
        result.setPagesize(pagesize);
        result.setTotalpage(totalpage);
        return result;
    }

    public static ApiPageResult<Object> SUCCESS() {
        ApiPageResult<Object> result = new ApiPageResult<>();
        return result;
    }

    public static ApiPageResult<Object> FAILURE() {
        return FAILURE("fail");
    }

    public static ApiPageResult<Object> FAILURE(String msg) {
        ApiPageResult<Object> result = new ApiPageResult<>();
        result.setResCode(-1);
        result.setResMsg(msg);
        return result;
    }

    public static ApiPageResult<Object> UNKNOWN() {
        ApiPageResult<Object> result = new ApiPageResult<>();
        result.setResCode(100);
        result.setResMsg("未登录，请先登录");
        return result;
    }


    public ApiPageResult(int resCode) {
        this.resCode = resCode;
    }

    public ApiPageResult(T data) {
        this.data = data;
    }

    public ApiPageResult() {
    }

    public ApiPageResult(String resMsg) {
        this.resMsg = resMsg;
    }

    public ApiPageResult(String resMsg, int resCode) {
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

    public long getCounts() {
        return counts;
    }

    public void setCounts(long counts) {
        this.counts = counts;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
