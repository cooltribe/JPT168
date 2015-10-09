package com.jpt168.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.jpt168.Exception.ResponseException;
import com.jpt168.application.Constants;
import com.jpt168.model.NameValue;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by caomingyu on 15/9/5.
 * email:361786231@qq.com
 */
public class HttpUtils {
    public static String get(String url) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().addHeader("x-client-identifier", "android").url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if(response.isSuccessful()){
            return  response.body().string();
        }else {
            ResponseException.getDetailMessage("Http_GET",response);
        }
        return null;
    }

    public static Bitmap getBitmap(String url) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().addHeader("x-client-identifie","android").url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if(response.isSuccessful()){
            return BitmapFactory.decodeStream(response.body().byteStream());
        }else{
            ResponseException.getDetailMessage("Http_GET",response);
        }
        return null;
    }

    /**
     * @param url
     * @param content
     * @return
     * @throws IOException
     */
    public static String Post(String url,String content) throws IOException {
        String resultData = "";
        URL httpUrl = null;
        try {
            httpUrl = new URL(Constants.HOST+url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (url != null) {
            try {
                HttpURLConnection urlConn = (HttpURLConnection) httpUrl.openConnection();
                urlConn.setDoInput(true);
                urlConn.setDoOutput(true);
                urlConn.setRequestMethod("POST");
                urlConn.setUseCaches(false);
                urlConn.setInstanceFollowRedirects(true);
                urlConn.setRequestProperty("contentType", "utf-8");
                urlConn.connect();
                DataOutputStream out = new DataOutputStream(urlConn.getOutputStream());
                Log.i("testPost", "content-->" + content);
                out.writeBytes(content);
                out.flush();
                out.close();
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "utf-8"));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    resultData += inputLine + "\n";
                }
                reader.close();
                urlConn.disconnect();
                Log.i("testPost", "resultData-->" + resultData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultData;
    }

    /**
     * 上传图片文件
     * @param url
     * @param nameValues 图片的namevalue必须以图片绝对路径传入
     * @return
     * @throws IOException
     */
    public static String PostPic(String url,ArrayList<NameValue> nameValues) throws IOException{
        String val;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("x-client-identifier", "android");
        httpPost.addHeader("Content-Type","multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");
        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());
        for(NameValue nameValue:nameValues){
            String name = nameValue.name;
            Object value = nameValue.value;
            val = (String)value;
            if(val.endsWith(".jpg")||val.endsWith(".JPG")||val.endsWith("png")||val.endsWith("PNG")){
                multipartEntity.addPart(name, new FileBody(new File(val),"image/jpeg"));
            }else{
                multipartEntity.addPart(name, new StringBody((String) value));
            }
        }
        httpPost.setEntity(multipartEntity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
        String sResponse;
        StringBuilder sb = new StringBuilder();
        while ((sResponse = bufferReader.readLine())!=null){
           sb = sb.append(sResponse);
        }
        return sb.toString();
    }

}
