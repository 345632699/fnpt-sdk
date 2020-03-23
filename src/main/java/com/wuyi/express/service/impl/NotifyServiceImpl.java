package com.wuyi.express.service.impl;

import com.wuyi.express.entity.Notify;
import com.wuyi.express.mapper.NotifyMapper;
import com.wuyi.express.service.NotifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xu
 * @since 2020-03-17
 */
@Service
public class NotifyServiceImpl extends ServiceImpl<NotifyMapper, Notify> implements NotifyService {

    @Autowired
    private NotifyMapper notifyMapper;

    @Override
    public Notify getByOrderNo(String orderNo) {
        return notifyMapper.getByOrderNo(orderNo);
    }
}
