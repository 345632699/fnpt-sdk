package com.wuyi.express.fnpt.config;

import com.wuyi.express.fnpt.FnClient;
import com.wuyi.express.fnpt.constant.ApiUrlConstant;
import com.wuyi.express.fnpt.service.AmapService;
import com.wuyi.express.fnpt.service.impl.AmapServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:42
 */
@Configuration
@EnableConfigurationProperties(Properties.class)
@Slf4j
public class FnptAutoConfiguration {

    private Properties sfCityProperties;

    @Autowired
    public FnptAutoConfiguration(Properties sfCityProperties) {
        this.sfCityProperties = sfCityProperties;

        ApiUrlConstant.setFnptHost(sfCityProperties.getApiUrl());
    }

    @Bean
    @ConditionalOnMissingBean
    public FnClient fnClient() {
        FnClient fnClient = new FnClient(
                sfCityProperties.getAppid(),
                sfCityProperties.getSecretKey(),
                sfCityProperties.getUserId(),
                sfCityProperties.getShopId()
        );
        return fnClient;
    }

    @Bean
    public AmapService amapService(){
        return new AmapServiceImpl();
    }
}
