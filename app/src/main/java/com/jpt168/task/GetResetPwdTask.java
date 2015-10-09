package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/16.
 * email:361786231@qq.com
 */
public class GetResetPwdTask extends JPTTask{

    private String userName;
    private String mobile;
    private String code;
    private int userId;

    public GetResetPwdTask(Context context, String userName, String mobile, String code, int userId) {
        super(context);
        this.userName = userName;
        this.mobile = mobile;
        this.code = code;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String resetPwdStr = BaseProtocal.getResetPwd(userName,mobile,code,userId);
        return JSON.parseObject(resetPwdStr, OrderQuery.class);
    }
}
