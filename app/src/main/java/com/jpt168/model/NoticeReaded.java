package com.jpt168.model;

import java.io.Serializable;

/**
 * Created by caomingyu on 15/9/10.
 * email:361786231@qq.com
 */
public class NoticeReaded implements Serializable{
    private int unReadedNumber;
    private int result;
    private String message;

    public int getUnReadedNumber() {
        return unReadedNumber;
    }

    public void setUnReadedNumber(int unReadedNumber) {
        this.unReadedNumber = unReadedNumber;
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
