package com.oudake.csrftest.auth.model;

/**
 * @author wangyi
 */
public class ResponseBean <T> {

    private Boolean success;
    private String code;
    private String msg;
    private T result;

    public ResponseBean() {
    }

    public ResponseBean(Boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(Boolean success, String code, String msg, T result) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
