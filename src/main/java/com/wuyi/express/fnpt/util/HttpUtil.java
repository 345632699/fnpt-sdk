package com.wuyi.express.fnpt.util;


import com.wuyi.express.exception.BaseException;
import com.wuyi.express.fnpt.FnClient;
import com.wuyi.express.fnpt.request.Request;
import com.wuyi.express.fnpt.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Slf4j
public class HttpUtil {

    public static String doRequest(FnClient fnClient, String url, Request request, String token)
            throws UnsupportedEncodingException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String time = System.currentTimeMillis() / 1000 + "";

        Map<String, String> businessPara = BeanUtils.describe(request);
        if (businessPara.containsKey("user_id")) {
            businessPara.put("user_id", fnClient.getUserId());
        }

        if (businessPara.containsKey("time")) {
            businessPara.put("time", time);
        }

        if (businessPara.containsKey("appid")) {
            businessPara.put("appid", fnClient.getAppid());
        }

        // 签名
        String sign = SignUtil.sign(businessPara, token, fnClient.getSecretKey(), fnClient.getAppid(), time, fnClient.getUserId());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        // 设置content-type
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 构建form表单参数组
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("appid", fnClient.getAppid());
        params.add("user_id", fnClient.getUserId());
        params.add("token", token);
        params.add("time", time);
        params.add("sign", sign);
        params.add("para", GsonUtil.GsonString(businessPara));

        log.info("params:{}", params);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

        String body = restTemplate.postForEntity(url, httpEntity, String.class).getBody();
        log.info("httpresponse: {}", body);

        Response response = GsonUtil.GsonToBean(body, Response.class);
        if (response.getErrno().equals("0")) {
            return body;
        } else {
            throw new BaseException(-1, response.getErrmsg());
        }
    }
}
