package com.wuyi.express.controller;


import com.google.gson.Gson;
import com.wuyi.express.CommonResult;
import com.wuyi.express.HttpRequestUtils;
import com.wuyi.express.entity.Notify;
import com.wuyi.express.fnpt.util.GsonUtil;
import com.wuyi.express.service.NotifyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xu
 * @since 2020-03-17
 */
@RestController
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    @GetMapping(value = "list")
    public CommonResult list() {
        Notify byId = notifyService.getById(1);
        return CommonResult.success(byId);
    }

    @PostMapping("add")
    public CommonResult add(@RequestBody Notify notify) {
        Notify byOrderNo = notifyService.getByOrderNo(notify.getOrderNo());
        if (byOrderNo != null) {
            return CommonResult.failed("无需重复上报");
        }
        notifyService.saveOrUpdate(notify);
        return CommonResult.success("");
    }

    @PostMapping("notify")
    public Object notify(@RequestParam Map<String, String> notify) throws Exception {
        String para = notify.get("para");
        Map<String, Object> map = GsonUtil.GsonToMaps(para.replace("\\", ""));
        String orderNo = map.get("order_no").toString();

        Notify byOrderNo = notifyService.getByOrderNo(orderNo);

        String s = HttpRequestUtils.httpPost(byOrderNo.getNotifyUrl(), map);
        Map<String, Object> responseMap = GsonUtil.GsonToMaps(s);
        Map response = new HashMap();
        if (responseMap.get("code").equals(new Double("0"))) {
            response.put("errno", 0);
            response.put("errmsg", "");
            response.put("data", "");
        } else {
            response.put("errno", -1);
            response.put("errmsg", "回调失败");
            response.put("data", "");
        }
        return response;
    }
}
