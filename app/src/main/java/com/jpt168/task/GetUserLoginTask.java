package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/16.
 * email:361786231@qq.com
 */
public class GetUserLoginTask extends JPTTask{

    private String userName;
    private String password;
    private int userId;

    public GetUserLoginTask(Context context, String userName, String password, int userId) {
        super(context);
        this.userName = userName;
        this.password = password;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String userLoginStr = BaseProtocal.getUserLogin(userName,password,userId);
        return JSON.parseObject(userLoginStr, OrderQuery.class);
    }
}
