package com.jpt168.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caomingyu on 15/9/8.
 * email:361786231@qq.com
 */
public class NewNotice implements Serializable{
    private int NewNoticesNumber;
    private int Result;
    private String Message;

    public int getNewNoticesNumber() {
        return NewNoticesNumber;
    }

    public void setNewNoticesNumber(int newNoticesNumber) {
        NewNoticesNumber = newNoticesNumber;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
