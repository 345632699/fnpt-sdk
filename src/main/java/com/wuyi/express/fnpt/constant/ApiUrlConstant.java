package com.wuyi.express.fnpt.constant;

/**
 * @author suxiaolin
 * @date 2019-04-26 11:31
 */
public class ApiUrlConstant {

    private static String fnptHost;

    private static final String GET_AUTH_TOKEN = "/openapi/isv/getauthtoken";

    private static final String GET_TOKEN = "/openapi/isv/gettoken";

    private static final String UPLOAD_FILE = "/openapi/isv/uploadfile";

    private static final String CREATE_SHOP = "/openapi/isv/createshop";

    private static final String CANCEL_ORDER = "/openapi/isv/cancelorder";

    private static final String GET_AVAILABLE_PRODUCT_LIST = "/openapi/isv/getavailableproductlist ";

    private static final String GET_ORDER_PRICE = "/openapi/isv/getorderprice";

    private static final String CREATE_ORDER = "/openapi/isv/createorder";

    private static final String ADD_TIPS = "/openapi/isv/addtip";

    private static final String GET_ORDER_DETAIL = "/openapi/isv/getorderdetail";

    private static final String GET_CANCEL_PRICE = "/openapi/isv/getcancelprice";

    public static String getAuthToken() {
        return fnptHost + GET_AUTH_TOKEN;
    }

    public static String getToken() {
        return fnptHost + GET_TOKEN;
    }

    public static String uploadFile() {
        return fnptHost + UPLOAD_FILE;
    }

    public static String createShop() {
        return fnptHost + CREATE_SHOP;
    }

    public static String cancelOrder() {
        return fnptHost + CANCEL_ORDER;
    }

    public static String getAvailableProductList() {
        return fnptHost + GET_AVAILABLE_PRODUCT_LIST;
    }

    public static String getOrderPrice() {
        return fnptHost + GET_ORDER_PRICE;
    }

    public static String createOrder() {
        return fnptHost + CREATE_ORDER;
    }

    public static String addTips() {
        return fnptHost + ADD_TIPS;
    }

    public static String getOrderDetail() {
        return fnptHost + GET_ORDER_DETAIL;
    }
    public static String getCancelPrice() {
        return fnptHost + GET_CANCEL_PRICE;
    }


    public static void setFnptHost(String sfCityHost) {
        ApiUrlConstant.fnptHost = sfCityHost;
    }
}
