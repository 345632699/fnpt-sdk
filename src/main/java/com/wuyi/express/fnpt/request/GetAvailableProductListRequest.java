package com.wuyi.express.fnpt.request;

public class GetAvailableProductListRequest extends Request{
    String shop_id;
    String customer_lon;
    String customer_lat;
    String expect_fetch_time;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getCustomer_lon() {
        return customer_lon;
    }

    public void setCustomer_lon(String customer_lon) {
        this.customer_lon = customer_lon;
    }

    public String getCustomer_lat() {
        return customer_lat;
    }

    public void setCustomer_lat(String customer_lat) {
        this.customer_lat = customer_lat;
    }

    public String getExpect_fetch_time() {
        return expect_fetch_time;
    }

    public void setExpect_fetch_time(String expect_fetch_time) {
        this.expect_fetch_time = expect_fetch_time;
    }
}
