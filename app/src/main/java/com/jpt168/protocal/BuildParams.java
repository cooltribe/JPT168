package com.jpt168.protocal;

import com.jpt168.model.NameValue;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by caomingyu on 15/9/8.
 * email:361786231@qq.com
 */
public class BuildParams {
    public static String CreateJsonParams(ArrayList<NameValue> pair){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            if (pair != null){
                for (NameValue p : pair){
                    if(p!=null&&p.value!=null){
                        if (p.value instanceof ArrayList){
                            ArrayList<NameValue> nameValues = (ArrayList<NameValue>)p.value;
                            JSONObject json = new JSONObject();
                            for(int i = 0;i<nameValues.size();i++){
                                json.put(nameValues.get(i).name,nameValues.get(i).value);
                            }
                            jsonArray.put(json);
                            jsonObject.put(p.name,jsonArray);
                        }else {
                            jsonObject.put(p.name,p.value);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static ArrayList<NameValue> addParams(NameValue... nameValues){
        ArrayList<NameValue> params = new ArrayList<NameValue>();
        for (NameValue param:nameValues){
            params.add(param);
        }
        return params;
    }
}
