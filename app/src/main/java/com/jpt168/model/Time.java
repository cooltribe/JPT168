package com.jpt168.model;

import java.io.Serializable;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class Time implements Serializable {
    private String SystemTime;
    private int result;
    private String message;

    public String getSystemTime() {
        return SystemTime;
    }

    public void setSystemTime(String systemTime) {
        SystemTime = systemTime;
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
