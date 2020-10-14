package com.ballen.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;

public class JSONUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转JSON字符串
     *
     * @param data
     * @return
     */
    public static String ObjectToJson(Object data) {
        try {
            String string = objectMapper.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JSON字符串转对象
     * @param string
     * @param <T>
     * @return
     */
    public static <T>Object JsonToObject(String string,Class<T> baseType){
        try {
            T t = objectMapper.readValue(string, baseType);
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
//    中文乱码
public static String decode(String param){
    String result= null;
    try {
        result = new String(param.getBytes("utf-8"), "utf-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return result;
}
}
