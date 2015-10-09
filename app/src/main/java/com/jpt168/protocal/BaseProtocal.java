package com.jpt168.protocal;

import com.jpt168.application.Constants;
import com.jpt168.model.NameValue;
import com.jpt168.util.HttpUtils;
import com.jpt168.util.Util;

import java.io.IOException;

/**
 * Created by caomingyu on 15/9/8.
 *
 */
public class BaseProtocal {

    /**
     * 获取新通知
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getNewNotice(int userId) throws IOException{
        String partner = "jintong";
        String time = Util.partLongDateTOString(System.currentTimeMillis());
        return HttpUtils.Post(Constants.NEWNOTICE,
                "request={\"TimeSpan\":\"2015-07-01 15:07:54\",\"Partner\":\"jintong\",\"UserId\":2}");
    }

    /**
     * 获取已读通知
     * @param userId
     * @param noticeId
     * @param noticeFlag
     * @return
     * @throws IOException
     */
    public static String getNoticeReaded(int userId, int noticeId, int noticeFlag) throws IOException{
        String partner = "jintong";
        String time = Util.partLongDateTOString(System.currentTimeMillis());
        return HttpUtils.Post(Constants.NOTICEREADED,
                "request={\"TimeSpan\":\"2015-07-01 15:07:54\",\"Partner\":\"jintong\",\"NoticeFlag\":0,\"NoticeFlag\":110,\"UserId\":2}");

    }

    /**
     * 获取短信验证码
     * @param userName
     * @param mobileNumber
     * @param type
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getSMSCode(String userName, String mobileNumber, int type, int userId) throws  IOException{
        String partner = "jintong";
        String time = Util.partLongDateTOString(System.currentTimeMillis());
        return HttpUtils.Post(Constants.GETCODE,
                "request={\"TimeSpan\":\""+time+"\",\"Partner\":\"jintong\",\"UserId\":0,\"UserName\":\"chensp001\",\"Mobile\":\"13800138000\",\"Type\":2}");
    }

    /**
     * 获取通知
     * @param role
     * @param pageSize
     * @param pageIndex
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getNotice(int role,int pageSize,int pageIndex,int userId) throws IOException{
        String partner = "jintong";
        String time = Util.partLongDateTOString(System.currentTimeMillis());
        return HttpUtils.Post(Constants.NOTICE,
                "request={\"TimeSpan\":\"2015-06-23 15:01:57\",\"Partner\":\"jintong\",\"UserId\":2,\"PageSize\":5,\"PageIndex\":1,\"Role\":3}");
    }

    /**
     * 获取订单查询
     * @param orderState
     * @param userName
     * @param userRole
     * @param pageIndex
     * @param pageSize
     * @param airline
     * @param ticketNo
     * @param orderId
     * @param PNRCode
     * @param passengerName
     * @param flightNo
     * @param payMethod
     * @param dates
     * @param datee
     * @param userId
     * @param partner
     * @param timeSpan
     * @return
     * @throws IOException
     */
    public static String getOrderQuery(int orderState, String userName, int userRole, int pageIndex, int pageSize,
                                       String airline, String ticketNo, String orderId, String PNRCode, String passengerName, String flightNo,
                                       int payMethod, String dates, String datee, int userId, String partner, String timeSpan) throws IOException{
        return HttpUtils.Post(Constants.ORDERQUERY,
                "request={\"TimeSpan\":\"2015-06-18 14:41:55\",\"Partner\":\"jintong\",\"UserId\":2,\"UserName\":\"chensp001\",\"Airline\":\"\",\"OrderState\":[0, 1, 2],\"UserRole\":3,\"PageIndex\":1,\"PageSize\":10,\"TicketNo\":\"\",\"OrderId\":\"\",\"OrderId\":\"\",\"PassengerName\":\"\",\"FlightNo\":\"\",\"PayMethod\":0,\"DateS\":\"2015-06-17 00:00:00\",\"DateE\":\"2015-06-18 00:00:00\"}");

    }

    /**
     * 获取城市列表
     * @return
     * @throws IOException
     */
    public static String getCity() throws IOException{
        return HttpUtils.Post(Constants.CITY,"");
    }

    /**
     * 获取服务器时间
     * @return
     * @throws IOException
     */
    public static String getTime() throws IOException{
        return HttpUtils.Post(Constants.HOSTTIME,"");
    }

    /**
     * 获取国家列表
     * @return
     * @throws IOException
     */
    public static String getCountry() throws IOException{
        return HttpUtils.Post(Constants.COUNTRY,"");
    }

    /**
     * 获取航司信息列表
     * @return
     * @throws IOException
     */
    public static String getAirline() throws IOException{
        return HttpUtils.Post(Constants.AIRLINE,"");
    }

    /**
     * 获取机场信息
     * @return
     * @throws IOException
     */
    public static String getAirport() throws IOException{
        return HttpUtils.Post(Constants.AIRPORT,"");
    }

    /**
     * 常旅客查询
     * @param passengerId
     * @param passengerName
     * @param passengerType
     * @param pageSize
     * @param pageIndex
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getFrequentQuery(int passengerId, String passengerName, int passengerType, int pageSize, int pageIndex, int userId) throws IOException{
        return  HttpUtils.Post(Constants.FREQUENTQUERY,
                "request={\"TimeSpan\":\"2015-06-19 11:04:39\",\"Partner\":\"jintong\",\"UserId\":2,\"PassengerName\":\"zhang\",\"PassengerId\":0,\"PassengerType\":99,\"PageSize\":2,\"PageIndex\":1}");
    }

    /**
     * 增加常旅客
     * @param passengerId
     * @param name
     * @param sex
     * @param birthday
     * @param PassengerType
     * @param IDNumber
     * @param IDType
     * @param nationality
     * @param idValidDate
     * @param POI
     * @param mobile
     * @param telephone
     * @param email
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getFrequentAdd(int passengerId, String name, int sex, String birthday, int PassengerType, String IDNumber, int IDType, String nationality, String idValidDate, String POI, String mobile, String telephone, String email, int userId) throws IOException{
        return HttpUtils.Post(Constants.FREQUENTADD,
                "request={\"TimeSpan\":\"2015-06-19 11:04:39\",\"Partner\":\"jintong\",\"UserId\":2,\"Passengers\":[{\"Name\":\"caomingyu\",\"PassengerId\":8036,\"PassengerType\":0,\"Sex\":0,\"IDType\":1,\"Birthday\":\"1980-01-01 00:00:00\",\"IDNumber\":\"G12345678\",\"Nationality\":\"CN\",\"IDValidDate\":\"2020-06-19 00:00:00\",\"POI\":\"CN\",\"Mobile\":\"13800138000\",\"Telephone\":\"021-12345678\",\"Email\":\"testabc@testabc.com\"}]}");
    }

    /**
     * 更新常旅客
     * @param passengerId
     * @param name
     * @param sex
     * @param birthday
     * @param passengerType
     * @param idNumber
     * @param idType
     * @param nationality
     * @param idValidDate
     * @param POI
     * @param mobile
     * @param telephone
     * @param email
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getFrequentUpdate(int passengerId, String name, int sex, String birthday, int passengerType, String idNumber, int idType, String nationality, String idValidDate, String POI, String mobile, String telephone, String email, int userId) throws IOException{
        return HttpUtils.Post(Constants.FREQUENTUPDATE,
                "request={\"TimeSpan\":\"2015-06-19 11:04:39\",\"Partner\":\"jintong\",\"UserId\":2,\"Passengers\":[{\"Name\":\"caomingyu\",\"PassengerId\":8036,\"PassengerType\":1,\"Sex\":1,\"IDType\":0,\"Birthday\":\"2005-01-01 00:00:00\",\"IDNumber\":\"1234567890156\",\"Nationality\":\"US\",\"IDValidDate\":\"2025-06-19 00:00:00\",\"POI\":\"US\",\"Mobile\":\"987654321\",\"Telephone\":\"13579\",\"Email\":\"update@msn.com\"}]}\"");

    }

    /**
     * 删除常旅客
     * @param passengerId
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getFrequentDel(int passengerId, int userId) throws IOException{
        return HttpUtils.Post(Constants.FREQUENTDEL,
                "request={\"TimeSpan\":\"2015-06-19 16:33:55\",\"Partner\":\"jintong\",\"UserId\":2,\"PassengerId\":8036}");
    }

    /**
     * 创建订单
     * @param flightId
     * @param name
     * @param sex
     * @param birthday
     * @param passengerType
     * @param idNumber
     * @param idType
     * @param nationality
     * @param idValidDate
     * @param clientIP
     * @param contactor
     * @param contactorTel
     * @param contactMobile
     * @param orderRemark
     * @param isForeigner
     * @param isXinJiang
     * @param userId
     * @return
     * @throws IOException
     */
    public static String createOrder(String flightId, String name, int sex, String birthday, int passengerType, String idNumber, int idType, String nationality, String idValidDate, String clientIP, String contactor, String contactorTel, String contactMobile, String orderRemark, boolean isForeigner, boolean isXinJiang, int userId) throws IOException{
        return HttpUtils.Post(Constants.CREATEORDER,
                "request={\"TimeSpan\":\"2015-06-17 13:35:01\",\"Partner\":\"jintong\",\"UserId\":2,\"IsXinJiang\":false,\"IsForeigner\":false,\"OrderRemark\":\"\",\"ContactMobile\":\"\",\"ContactTel\":\"\",\"Contactor\":\"\",\"ClientIP\":\"127.0.0.1\",\"BufferKey\":\"RTPVGHKG20150622_00010101Y_ADU_1_\",\"FlightId\":\"8c5f3d65-decb-4342-9c38-e00165167073\",\"Passengers\":[{\"Name\":\"ZHANG/KANGXIN\",\"PassengerType\":0,\"Sex\":0,\"IDType\":1,\"Birthday\":\"1980-01-01 00:00:00\",\"IDNumber\":\"G12345678\",\"Nationality\":\"CN\",\"IDValidDate\":\"2020-01-01 00:00:00\"}]}\"");
    }

    /**
     * 获取Web支付地址
     * @param orderId
     * @param payType
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getPayUrl(String orderId, String payType, int userId) throws IOException{
        return HttpUtils.Post(Constants.PAYURL,
                "request={\"TimeSpan\":\"2015-06-23 16:20:20\",\"Partner\":\"jintong\",\"UserId\":2,\"PayType\":\"ZFB\",\"OrderId\":\"150617595197\"}");

    }

    /**
     * 获取支付宝验证
     * @param orderId
     * @param payType
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getPayVerify(String orderId, String payType, int userId) throws IOException{
        return HttpUtils.Post(Constants.PAYVERIFY,
                "request={\"TimeSpan\":\"2015-06-23 15:21:46\",\"Partner\":\"jintong\",\"UserId\":2,\"PayType\":\"ZFB\",\"OrderId\":\"150617595197\"}");
    }

    /**
     * 退改签
     * @param bufferKey
     * @param FlightId
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getFareRule(String bufferKey, String FlightId, int userId) throws IOException{
        return HttpUtils.Post(Constants.FareRule,
                "request={\"TimeSpan\":\"2015-06-16 14:15:11\",\"Partner\":\"jintong\",\"UserId\":2,\"FlightId\":\"ea369c90-508d-40a5-af8b-2eae591253a9\",\"BufferKey\":\"RTPVGHKG20150621_00010101Y_ADU_1_\"}");
    }

    /**
     * 验仓
     * @param bufferKey
     * @param flightId
     * @param passNumber
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getCabinCheck(String bufferKey, String flightId, int passNumber, int userId) throws IOException{
        return HttpUtils.Post(Constants.CABINCHECK,
                "request={\"TimeSpan\":\"2015-06-16 14:15:11\",\"Partner\":\"jintong\",\"UserId\":2,\"FlightId\":\"e1fec756-c706-4181-8329-f35e466ce754\",\"BufferKey\":\"RTPVGHKG20150621_00010101Y_ADU_1_\",\"PassNumber\":1}");
    }

    /**
     * 验价
     * @param bufferKey
     * @param flightId
     * @param adultNum
     * @param childNum
     * @param infNum
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getPriceCheck(String bufferKey, String flightId, int adultNum, int childNum, int infNum, int userId) throws IOException{
        return HttpUtils.Post(Constants.PRICECHECK,
                "request={\"TimeSpan\":\"2015-06-16 16:30:09\",\"Partner\":\"jintong\",\"UserId\":2,\"FlightId\":\"70bada30-eabc-461b-b5fb-47aef857af44\",\"BufferKey\":\"RTPVGHKG20150621_00010101Y_ADU_1_\",\"AdultNum\":1,\"ChildNum\":0,\"InfNum\":0}");

    }

    /**
     * 查询所属经销
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getDealer(int userId) throws IOException{
        return HttpUtils.Post(Constants.DEALER,
                "request={\"TimeSpan\":\"2015-06-18 15:40:52\",\"Partner\":\"jintong\",\"UserId\":2}");
    }

    /**
     * 查询下属分销
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getConsumers(int userId) throws IOException{
        return HttpUtils.Post(Constants.CONSUMERS,
                "request={\"TimeSpan\":\"2015-06-18 15:40:52\",\"Partner\":\"jintong\",\"UserId\":1}");
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getUserLogin(String userName, String password, int userId) throws IOException{
        return HttpUtils.Post(Constants.USERLOGIN,
                "request={\"TimeSpan\":\"2015-06-11 17:37:31\",\"Partner\":\"jintong\",\"UserId\":0,\"UserName\":\"chensp001\",\"Password\":\"666888\"}");

    }

    /**
     * 重置密码
     * @param userName
     * @param mobile
     * @param code
     * @param userId
     * @return
     * @throws IOException
     */
    public static String getResetPwd(String  userName, String mobile, String code, int userId) throws IOException{
        return HttpUtils.Post(Constants.RESETPWD,
                "request={\"TimeSpan\":\"2015-06-11 17:37:31\",\"Partner\":\"jintong\",\"UserId\":0,\"UserName\":\"chensp001\",\"Mobile\":\"13801639889\",\"Code\":\"8wnqs8\",\"Type\":2}");

    }
}
