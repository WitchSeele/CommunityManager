package com.exception;

public class UnLoginException extends RuntimeException {

    private static final long serialVersionUID = -4454567895971040211L;

    public UnLoginException() {
        super("未登录或登录失效，请先登录");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
