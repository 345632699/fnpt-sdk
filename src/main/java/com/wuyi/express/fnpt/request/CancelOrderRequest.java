package com.wuyi.express.fnpt.request;

public class CancelOrderRequest extends Request {
    String order_no;
    String cancel_charge;
    String user_id;
    String cancel_reason;
    String other_reason;
    String appid;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCancel_charge() {
        return cancel_charge;
    }

    public void setCancel_charge(String cancel_charge) {
        this.cancel_charge = cancel_charge;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public String getOther_reason() {
        return other_reason;
    }

    public void setOther_reason(String other_reason) {
        this.other_reason = other_reason;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
