package com.djc.scene.domain.result;

public class ResultJson<T> {

    public static final String OK = "ok";
    public static final String NO_AUTH = "no_auth";
    public static final String INNER_ERROR = "inner_error";
    public static final String BAD_REQUEST = "bad_request";

    private T data;
    private int status;
    private String message;

    public ResultJson() {
        this.message = OK;
    }

    public ResultJson(T data) {
        this.data = data;
        this.message = OK;
    }

    public ResultJson(T data, int status) {
        this.data = data;
        this.status = status;
        this.message = OK;
    }

    public ResultJson(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static<T> ResultJson<T> success() {
        return new ResultJson<>();
    }

    public static<T> ResultJson<T> success(T data) {
        return new ResultJson<>(data);
    }

    public static<T> ResultJson<T> failed(T data,int status){
        return new ResultJson<>(data,status);
    }
    public static<T> ResultJson<T> failed(int status,String message){
        return new ResultJson<>(status,message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
