package com.wuyi.express.controller;


import com.wuyi.express.CommonResult;
import com.wuyi.express.entity.Notify;
import com.wuyi.express.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xu
 * @since 2020-03-17
 */
@RestController
@RequestMapping("/notify")
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
        notifyService.save(notify);
        return CommonResult.success("");
    }
}
