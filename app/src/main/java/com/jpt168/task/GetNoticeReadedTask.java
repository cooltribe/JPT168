package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.NoticeReaded;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/9.
 * email:361786231@qq.com
 */
public class GetNoticeReadedTask extends JPTTask {

    private int userId;
    private int noticeId;
    private int noticeFlag;

    public GetNoticeReadedTask(Context context, int userId, int noticeId, int noticeFlag) {
        super(context);
        this.userId = userId;
        this.noticeId = noticeId;
        this.noticeFlag = noticeFlag;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String noticeReaded = BaseProtocal.getNoticeReaded(userId,noticeId,noticeFlag);
        Log.i("testApi","noticeReaded-->" + noticeReaded);
        return JSON.parseObject(noticeReaded, NoticeReaded.class);
    }
}
