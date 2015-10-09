package com.jpt168.application;

/**
 * Created by caomingyu on 15/9/5.
 * email:361786231@qq.com
 */
public interface Constants {
    public static final boolean debug = true;
//    public static final String TAG = "jpt168";
    //服务器地址
    public static final String HOST = "http://124.74.111.138:6010";
    //获取服务器时间
    public static final String HOSTTIME = "/secure/gettime";
    //获取城市信息地址
    public static final String CITY = "/commdata/City";
    //获取国家信息地址
    public static final String COUNTRY = "/commdata/Country";
    //获取航司信息地址
    public static final String AIRLINE = "/commdata/Airline";
    //获取机场信息地址
    public static final String AIRPORT = "/commdata/Airport";
    //常旅客查询地址
    public static final String FREQUENTQUERY = "/user/FrequentQuery";
    //新增常旅客地址
    public static final String FREQUENTADD = "/user/FrequentAdd";
    //更新常旅客地址
    public static final String FREQUENTUPDATE = "/user/FrequentUpdate";
    //删除常旅客地址
    public static final String FREQUENTDEL = "/user/FrequentDel";
    //订单查询地址
    public static final String ORDERQUERY = "/order/query";
    //公告接口
    public static final String NOTICE = "/user/GetNotice";
    //公告地址(已读)
    public static final String NOTICEREADED = "/user/NoticeReaded";
    //公告地址(未读数量)
    public static final String NEWNOTICE = "/user/GetNewNoticesNumber";
    //获取短信验证码地址
    public static final String GETCODE = "/sms/getcode";
    //创单请求地址
    public static final String CREATEORDER = "/book/createorder";
    //获取Web支付地址请求
    public static final String PAYURL = "/order/PayUrl";
    //支付宝验证请求
    public static final String PAYVERIFY = "/order/PayVerify";
    //退改签请求地址
    public static final String FareRule = "/book/FareRule";
    //验仓请求
    public static final String CABINCHECK = "/book/cabincheck";
    //验价请求
    public static final String PRICECHECK = "/book/pricecheck";
    //查询所属经销请求
    public static final String DEALER = "/user/getdealer";
    //查询下属分销请求
    public static final String CONSUMERS = "/user/GetConsumers";
    //用户登录
    public static final String USERLOGIN = "/user/Login";
    //重置密码
    public static final String RESETPWD = "/user/ResetPwd";

    /*
    - 400: parameter is not json
    - 404: page not found
    - 500: generic error
    - 501: parameter invalid
    - 502: duplicate record found 重复
    - 503: access denied
    - 505: record not found 没找到
    - 506: internal database error
    - 507: old password not match
    - 508: permissions denied
    - 509: image file error
    - 510: paragraph not save yet
     */
    public static final int NOTJSON = 400;//无效数据
    public static final int NOTFINDPAGE = 404;//没有找到该页
    public static final int  SERVERERROR = 500;//服务器异常
    public static final int PARAMETERINVALID = 501; //无效参数
    public static final int DUPLICATE_INVALID = 502 ;//记录重复
    public static final int ACCESSDENIED = 503;//拒绝访问
    public static final int RECORD_NOT_FOUND = 505;//记录未找到
    public static final int INTERNAL_DATABASE_ERROR = 506 ;//服务器数据出错
    public static final int OLD_PASSWORD_ERROR = 507 ;//旧密码错误
    public static final int PERMISSIONS_DENIED = 508 ;//未授权
    public static final int IMAGE_FILE_ERROR = 509 ;//图形文件错误
    public static final int PARAGRAPH_NOT_SAVE = 510 ;//片段未存储

}
