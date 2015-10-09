package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.NewNotice;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/8.
 * email:361786231@qq.com
 */
public class GetNewNoticeTask extends JPTTask{
    private int userId;

    public GetNewNoticeTask(Context context, int userId) {
        super(context);
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String newNotice = BaseProtocal.getNewNotice(userId);
        return JSON.parseObject(newNotice, NewNotice.class);
    }
}
