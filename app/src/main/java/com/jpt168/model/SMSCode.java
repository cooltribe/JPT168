package com.jpt168.model;

import java.io.Serializable;

/**
 * Created by caomingyu on 15/9/10.
 * email:361786231@qq.com
 */
public class SMSCode implements Serializable{
    private String operationResult;
    private int result;
    private String message;

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
