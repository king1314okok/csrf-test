package com.oudake.csrftest.model;

import java.io.Serializable;

/**
 * @author wangyi
 */
public class ResponseBean implements Serializable {

    private Boolean success;
    private String code;
    private String msg;
    private Object result;

    public ResponseBean() {
    }

    public ResponseBean(Boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(Boolean success, String code, String msg, Object result) {
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

    public void setResult(Object result) {
        this.result = result;
    }
}
