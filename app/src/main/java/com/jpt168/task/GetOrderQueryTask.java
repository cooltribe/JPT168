package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class GetOrderQueryTask extends JPTTask {

    private int orderState;
    private String userName;
    private int userRole;
    private int pageIndex;
    private int pageSize;
    private String airline;
    private String tickNo;
    private String orderId;
    private String PNRCode;
    private String passengerName;
    private String flightNo;
    private int payMethod;
    private String dates;
    private String datee;
    private int userId;
    private String partner;
    private String timeSpan;

    public GetOrderQueryTask(Context context, int orderState, String userName, int userRole, int pageIndex, int pageSize, String airline, String tickNo, String orderId, String PNRCode, String passengerName, String flightNo, int payMethod, String dates, String datee, int userId, String partner, String timeSpan) {
        super(context);
        this.orderState = orderState;
        this.userName = userName;
        this.userRole = userRole;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.airline = airline;
        this.tickNo = tickNo;
        this.orderId = orderId;
        this.PNRCode = PNRCode;
        this.passengerName = passengerName;
        this.flightNo = flightNo;
        this.payMethod = payMethod;
        this.dates = dates;
        this.datee = datee;
        this.userId = userId;
        this.partner = partner;
        this.timeSpan = timeSpan;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String orderQueryStr = BaseProtocal.getOrderQuery(orderState,userName,userRole,pageIndex,pageSize,airline,tickNo,orderId,PNRCode,passengerName,flightNo,payMethod,dates,datee,userId,partner,timeSpan);
        Log.i("testApi", "orderQueryStr-->" + orderQueryStr);
        return JSON.parseObject(orderQueryStr,OrderQuery.class);
    }
}
