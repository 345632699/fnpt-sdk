package com.wuyi.express.fnpt.request;

public class CreateOrderRequest extends Request {
    String user_id;
    String out_order_no;
    String coupon_id;
    String shop_id;
    String customer_tel;
    String customer_addr;
    String customer_poi_addr;
    String customer_longtitude;
    String customer_latitude;
    String customer_name;
    String total_price;
    String pay_price;
    String product_id;
    String goods_weight;
    String order_price_detail_json;
    String expect_fetch_time;
    String t_indexid;
    String goods_price;

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setOut_order_no(String out_order_no) {
        this.out_order_no = out_order_no;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public void setCustomer_addr(String customer_addr) {
        this.customer_addr = customer_addr;
    }

    public void setCustomer_poi_addr(String customer_poi_addr) {
        this.customer_poi_addr = customer_poi_addr;
    }

    public void setCustomer_longtitude(String customer_longtitude) {
        this.customer_longtitude = customer_longtitude;
    }

    public void setCustomer_latitude(String customer_latitude) {
        this.customer_latitude = customer_latitude;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public void setPay_price(String pay_price) {
        this.pay_price = pay_price;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setGoods_weight(String goods_weight) {
        this.goods_weight = goods_weight;
    }

    public void setOrder_price_detail_json(String order_price_detail_json) {
        this.order_price_detail_json = order_price_detail_json;
    }

    public void setExpect_fetch_time(String expect_fetch_time) {
        this.expect_fetch_time = expect_fetch_time;
    }

    public void setT_indexid(String t_indexid) {
        this.t_indexid = t_indexid;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getOut_order_no() {
        return out_order_no;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public String getCustomer_addr() {
        return customer_addr;
    }

    public String getCustomer_poi_addr() {
        return customer_poi_addr;
    }

    public String getCustomer_longtitude() {
        return customer_longtitude;
    }

    public String getCustomer_latitude() {
        return customer_latitude;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getTotal_price() {
        return total_price;
    }

    public String getPay_price() {
        return pay_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getGoods_weight() {
        return goods_weight;
    }

    public String getOrder_price_detail_json() {
        return order_price_detail_json;
    }

    public String getExpect_fetch_time() {
        return expect_fetch_time;
    }

    public String getT_indexid() {
        return t_indexid;
    }
}
