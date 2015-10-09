package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class CreateOrderTask extends JPTTask{

    private String flightId;
    private String name;
    private int sex;
    private String birthday;
    private int passengerType;
    private String idNumber;
    private int idType;
    private String nationality;
    private String idValidDate;
    private String clientIP;
    private String contactor;
    private String contactTel;
    private String contactMobile;
    private String OrderRemark;
    private boolean isForeigner;
    private boolean isXinJiang;
    private int userId;


    public CreateOrderTask(Context context, String flightId, String name, int sex, String birthday, int passengerType, String idNumber, int idType, String nationality, String idValidDate, String clientIP, String contactor, String contactTel, String contactMobile, String orderRemark, boolean isForeigner, boolean isXinJiang, int userId) {
        super(context);
        this.flightId = flightId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.passengerType = passengerType;
        this.idNumber = idNumber;
        this.idType = idType;
        this.nationality = nationality;
        this.idValidDate = idValidDate;
        this.clientIP = clientIP;
        this.contactor = contactor;
        this.contactTel = contactTel;
        this.contactMobile = contactMobile;
        this.OrderRemark = orderRemark;
        this.isForeigner = isForeigner;
        this.isXinJiang = isXinJiang;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String createOrderStr = BaseProtocal.createOrder(flightId,name,sex,birthday,passengerType,idNumber,idType,nationality,idValidDate,clientIP,contactor,contactTel,contactMobile,OrderRemark,isForeigner,isXinJiang,userId);
        return JSON.parseObject(createOrderStr, OrderQuery.class);
    }
}
