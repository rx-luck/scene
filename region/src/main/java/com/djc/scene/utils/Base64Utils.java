package com.djc.scene.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    /**
     * 将byte[] 数组转换为base64编码的字符串
     * @param bytes
     * @return
     */
    public static String toBase64(byte[] param){
        byte[] files = Base64.getEncoder().encode(param);
        return new String(files, StandardCharsets.UTF_8);
    }

    /**
     * 将string 转换为数组
     * @param param
     * @return
     */
    public static byte[] toBytes(String param){
        return Base64.getDecoder().decode(param);
    }
}
