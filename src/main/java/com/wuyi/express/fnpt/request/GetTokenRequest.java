package com.wuyi.express.fnpt.request;

import lombok.Data;

@Data
public class GetTokenRequest extends Request {
    String appid;
    String time;
    String user_id;
}
