package com.example.SpringBootMybatis.util;

public class ResultUtil {

    public static Result success(int status, String message, Object data) {
        Result result;
        if (null != data) {
            result = new Result(status, message, data);
        } else {
            result = new Result(status, message, null);
        }
        return result;
    }

    public static Result success(int status, String message) {
        Result result = new Result(status, message, null);
        return result;
    }

    public static Result fail(int status, String message, Object data) {
        Result result = new Result(status, message, data);
        return result;
    }

    public static Result fail(String message) {
        return fail(0, message, null);
    }
}
