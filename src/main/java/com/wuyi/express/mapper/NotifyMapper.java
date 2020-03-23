package com.wuyi.express.mapper;

import com.wuyi.express.entity.Notify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xu
 * @since 2020-03-17
 */
@Repository
public interface NotifyMapper extends BaseMapper<Notify> {

    Notify getByOrderNo(String orderNo);
}
