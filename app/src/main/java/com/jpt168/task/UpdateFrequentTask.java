package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Frequent;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/13.
 * email:361786231@qq.com
 */
public class UpdateFrequentTask extends JPTTask {

    private int passengerId;
    private String name;
    private int sex;
    private String birthday;
    private int passengerType;
    private String idNumber;
    private int idType;
    private String nationality;
    private String idValidDate;
    private String POI;
    private String mobile;
    private String telephone;
    private String email;
    private int userId;

    public UpdateFrequentTask(Context context, int passengerId, String name, int sex, String birthday, int passengerType, String idNumber, int idType, String nationality, String idValidDate, String POI, String mobile, String telephone, String email, int userId) {
        super(context);
        this.passengerId = passengerId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.passengerType = passengerType;
        this.idNumber = idNumber;
        this.idType = idType;
        this.nationality = nationality;
        this.idValidDate = idValidDate;
        this.POI = POI;
        this.mobile = mobile;
        this.telephone = telephone;
        this.email = email;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String updateFrequentStr = BaseProtocal.getFrequentUpdate(passengerId,name,sex,birthday,passengerType,idNumber,idType,nationality,idValidDate,POI,mobile,telephone,email,userId);
        Log.i("testApi","updateFrequentStr-->" + updateFrequentStr);
        return JSON.parseObject(updateFrequentStr, Frequent.class);
    }
}
