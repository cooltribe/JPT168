package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.SMSCode;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/10.
 * email:361786231@qq.com
 */
public class GetSMSCodeTask extends JPTTask{

    private String userName;
    private String mobileNumber;
    private int type;
    private int userId;

    public GetSMSCodeTask(Context context, String userName, String mobileNumber, int type, int userId) {
        super(context);
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.type = type;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String SMSCode = BaseProtocal.getSMSCode(userName,mobileNumber,type,userId);
        return JSON.parseObject(SMSCode, SMSCode.class);
    }
}
