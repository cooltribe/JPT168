package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class GetPriceCheckTask extends JPTTask{

    private String bufferKey;
    private String flightId;
    private int adultNum;//成人数
    private int childNum;//小孩数
    private int infNum;//婴儿数
    private int userId;

    public GetPriceCheckTask(Context context, String bufferKey, String flightId, int adultNum, int childNum, int infNum,int userId) {
        super(context);
        this.bufferKey = bufferKey;
        this.flightId = flightId;
        this.adultNum = adultNum;
        this.childNum = childNum;
        this.infNum = infNum;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String priceCheckStr = BaseProtocal.getPriceCheck(bufferKey,flightId,adultNum,childNum,infNum,userId);
        return JSON.parseObject(priceCheckStr, OrderQuery.class);
    }
}
