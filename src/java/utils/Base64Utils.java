/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author Administrator
 */
public class Base64Utils {

    public static String encode(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }

    public static String decode(String s) throws UnsupportedEncodingException {
        byte[] asBytes = Base64.getDecoder().decode(s);
        return new String(asBytes, "utf-8");
    }

}
