package com.wuyi.express.fnpt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:46
 */
@ConfigurationProperties(prefix = "fnpt")
@Data
public class Properties {

    private String appid;

    private String secretKey;

    private String userId;
    
    private String apiUrl;

    private String shopId;

}