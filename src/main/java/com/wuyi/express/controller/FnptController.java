package com.wuyi.express.controller;

import com.wuyi.express.CommonResult;
import com.wuyi.express.fnpt.FnClient;
import com.wuyi.express.fnpt.constant.ApiUrlConstant;
import com.wuyi.express.fnpt.request.GetTokenRequest;
import com.wuyi.express.fnpt.util.GsonUtil;
import com.wuyi.express.fnpt.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class FnptController {
    @Autowired
    FnClient fnClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("getToken")
    public CommonResult getToken() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, UnsupportedEncodingException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        if (StringUtils.isNoneBlank(redisTemplate.opsForValue().get("fnptToken"))) {
            return CommonResult.success(redisTemplate.opsForValue().get("fnptToken"));
        } else {
            String responseBody = HttpUtil.doRequest(
                    fnClient,
                    ApiUrlConstant.getToken(),
                    getTokenRequest,
                    null
            );
            Map<String, String> map = GsonUtil.GsonToMaps(responseBody);
            Map<String, Object> data = GsonUtil.GsonToMaps(map.get("data"));
            long tokenExpireAt = new BigDecimal((Double) data.get("token_expire_at")).longValue();
            long currentTime = System.currentTimeMillis() / 1000;
            long expiredTime = tokenExpireAt - currentTime;
            redisTemplate.opsForValue().set("fnptToken", data.get("token").toString(), expiredTime, TimeUnit.MILLISECONDS);

            return CommonResult.success(data.get("token"));
        }
    }
}
