package com.wuyi.express.fnpt.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {
    public static String sign(Map<String , String> businessPara, String token, String secretKey, String appid, String time, String userId) throws UnsupportedEncodingException{

        TreeMap<String,String> sortMap = new TreeMap<>();
        sortMap.put("appid", appid);
        if (token != null) {
            sortMap.put("token", token );
        }

        // 添加secret_key
        if (!businessPara.containsKey("auth_token")) {
            sortMap.put("time", time);
            sortMap.put("user_id", userId);
            sortMap.put("secret_key", secretKey);
        }
//        for (Map.Entry<String, String> o : publicPara.entrySet()) {
//            sortMap.put(o.getKey(),o.getValue());
//        }
        if (businessPara != null) {
            for (Map.Entry<String, String> o : businessPara.entrySet()) {
                sortMap.put(o.getKey(),o.getValue());
            }
        }

        String encodeUrl = buildUri(sortMap);
        System.out.println(encodeUrl);

        String sign = DigestUtils.md5Hex(getContentBytes(encodeUrl, "utf-8"));
        System.out.println("sign:" + sign);
        return sign;
    }

    private static String buildUri(TreeMap<String, String> sortMap) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        sortMap.forEach((key, value) -> {
            stringBuilder.append(key).append("=").append(value);
            stringBuilder.append("&");
        });
        String encodeUrl = stringBuilder.toString();
        if (!encodeUrl.isEmpty()) {
            encodeUrl = encodeUrl.substring(0, encodeUrl.length() - 1);
        }
        encodeUrl = URLEncoder.encode(encodeUrl, "utf-8");
        return encodeUrl;
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
}
