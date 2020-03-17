package com.wuyi.express.fnpt.request;

public class GetCancelPriceRequest extends Request {
    String order_no;
    Integer order_status;
    Integer order_reason_code;
    String user_id;
    String appid;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Integer getOrder_reason_code() {
        return order_reason_code;
    }

    public void setOrder_reason_code(Integer order_reason_code) {
        this.order_reason_code = order_reason_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
