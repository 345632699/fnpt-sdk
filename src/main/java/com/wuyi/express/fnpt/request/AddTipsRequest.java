package com.wuyi.express.fnpt.request;

public class AddTipsRequest extends Request {
    Integer add_tip_price;
    String order_no;
    String appid;
    String business_sn;

    public Integer getAdd_tip_price() {
        return add_tip_price;
    }

    public void setAdd_tip_price(Integer add_tip_price) {
        this.add_tip_price = add_tip_price;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBusiness_sn() {
        return business_sn;
    }

    public void setBusiness_sn(String business_sn) {
        this.business_sn = business_sn;
    }
}
