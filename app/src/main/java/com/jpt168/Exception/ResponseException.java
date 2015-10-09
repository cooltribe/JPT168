package com.jpt168.Exception;

import com.jpt168.application.Constants;
import com.jpt168.application.LogManager;
import com.squareup.okhttp.Response;

/**
 * Created by caomingyu on 15/9/5.
 * email:361786231@qq.com
 */
public class ResponseException {

    public static void getDetailMessage(String tag,Response response) throws HttpException{
        int code = response.networkResponse().code();
        String msg = "";
        if (Constants.NOTJSON==code) {
            msg  = "参数不是JSON格式";
            LogManager.e(msg);
        } else if (Constants.NOTFINDPAGE == code) {
            msg  = "当前页面已遗失";
            LogManager.e(msg);
        } else if (Constants.SERVERERROR == code) {
            msg  = "服务器出错,请稍后再试！";
            LogManager.e(msg);
        } else if (Constants.PARAMETERINVALID == code) {
            msg  = "参数无效";
            LogManager.e(msg);
        } else if (Constants.DUPLICATE_INVALID == code) {
            msg  = "记录重复";
            LogManager.e(msg);
        } else if (Constants.ACCESSDENIED == code) {
            msg  = "未授权";
            LogManager.e(msg);
        } else if (Constants.RECORD_NOT_FOUND == code) {
            msg = "未找到该条记录";
            LogManager.e(msg);
        } else if (Constants.INTERNAL_DATABASE_ERROR == code) {
            msg = "服务器内部数据错误";
            LogManager.e(msg);
        } else if (Constants.OLD_PASSWORD_ERROR == code) {
            msg  = "原始密码错误";
            LogManager.e(msg);
        } else if (Constants.PERMISSIONS_DENIED == code) {
            msg  = "服务器拒绝访问";
            LogManager.e(msg);
        } else if (Constants.IMAGE_FILE_ERROR == code) {
            msg  = "图片文件错误";
            LogManager.e(msg);
        } else if (Constants.PARAGRAPH_NOT_SAVE == code) {
            msg  = "段落未成功保存";
            LogManager.e(msg);
        }
        throw new HttpException(String.valueOf(code));
    }

}
