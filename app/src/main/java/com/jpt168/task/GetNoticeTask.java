package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.application.LogManager;
import com.jpt168.model.Notice;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/11.
 * email:361786231@qq.com
 */
public class GetNoticeTask extends JPTTask{

    private int role;
    private int pageSize;
    private int pageIndex;
    private int userId;

    public GetNoticeTask(Context context, int role, int pageSize, int pageIndex, int userId) {
        super(context);
        this.role = role;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String noticeStr = BaseProtocal.getNotice(role,pageSize,pageIndex,userId);
        LogManager.i("TestNoticeApi","noticeStr-->" + noticeStr);
        return JSON.parseObject(noticeStr, Notice.class);
    }
}
