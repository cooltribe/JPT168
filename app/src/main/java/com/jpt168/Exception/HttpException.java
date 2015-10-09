package com.jpt168.Exception;

import java.io.IOException;

/**
 * Created by honeyshare-B on 15/9/5.
 * email:657523985@qq.com
 */
public class HttpException extends IOException{
    public HttpException(String detailMessage) {
        super(detailMessage);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
