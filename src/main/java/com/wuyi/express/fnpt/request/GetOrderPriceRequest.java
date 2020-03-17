package com.wuyi.express.fnpt.request;

public class GetOrderPriceRequest extends Request {
    String user_id;
    String shop_id;
    String coupon_id;
    String product_id;
    String customer_lon;
    String customer_lat;
    String expect_fetch_time;
    String goods_weight;
    String goods_price;
    String order_tip;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public String getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(String goods_weight) {
        this.goods_weight = goods_weight;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getOrder_tip() {
        return order_tip;
    }

    public void setOrder_tip(String order_tip) {
        this.order_tip = order_tip;
    }
}
