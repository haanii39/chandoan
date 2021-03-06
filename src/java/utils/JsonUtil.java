/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 *
 * @author Administrator
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    public static String encode(Object obj) {
        String jsonStr = "";
        jsonStr = gson.toJson(obj);

        return jsonStr;
    }

    public static Gson getGson() {
        return gson;
    }

    public static <T> T decode(String jsonStr, Class<T> c) {
        T obj = null;
        try {
            obj = gson.fromJson(jsonStr, c);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return obj;
    }
}