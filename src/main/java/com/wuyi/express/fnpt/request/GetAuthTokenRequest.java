package com.wuyi.express.fnpt.request;

import lombok.Data;

@Data
public class GetAuthTokenRequest extends Request {
    String appid;
    String time;
}
