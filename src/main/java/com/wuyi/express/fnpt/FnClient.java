package com.wuyi.express.fnpt;

import com.wuyi.express.fnpt.constant.ApiUrlConstant;
import com.wuyi.express.fnpt.request.*;
import com.wuyi.express.fnpt.response.Product;
import com.wuyi.express.fnpt.response.Response;
import com.wuyi.express.fnpt.util.GsonUtil;
import com.wuyi.express.fnpt.util.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FnClient {
    /**
     * 门店appid
     */
    String appid;
    /**
     * 秘钥
     */
    String secretKey;

    String userId;

    String shopId;

    public FnClient(String appid, String secretKey, String userId, String shopId) {
        this.appid = appid;
        this.secretKey = secretKey;
        this.userId = userId;
        this.shopId = shopId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAuthToken(GetAuthTokenRequest getAuthTokenRequest) throws UnsupportedEncodingException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String authToken = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getAuthToken(),
                getAuthTokenRequest,
                null
        );
        return authToken;
    }

    /**
     * 获取token
     *
     * @param getTokenRequest
     * @return
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws UnsupportedEncodingException
     */
    public String getToken(GetTokenRequest getTokenRequest) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, UnsupportedEncodingException {
//        if (StringUtils.isNoneBlank(redisTemplate.opsForValue().get("fnptToken"))) {
//            return redisTemplate.opsForValue().get("fnptToken");
//        } else {
//            String responseBody = HttpUtil.doRequest(
//                    this,
//                    ApiUrlConstant.getToken(),
//                    getTokenRequest,
//                    null
//            );
//            Map<String, String> map = GsonUtil.GsonToMaps(responseBody);
//            Map<String, String> data = GsonUtil.GsonToMaps(map.get("data"));
//
//            String tokenExpireAt = data.get("token_expire_at");
//            long currentTime = System.currentTimeMillis() / 1000;
//            long expiredTime = Long.parseLong(tokenExpireAt) - currentTime;
//            redisTemplate.opsForValue().set("fnptToken",data.get("token"),  expiredTime, TimeUnit.MILLISECONDS);
//            return data.get("token");
//        }
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getToken(),
                getTokenRequest,
                null
        );
        Map<String, String> map = GsonUtil.GsonToMaps(responseBody);
        Map<String, String> data = GsonUtil.GsonToMaps(map.get("data"));
        return data.get("token");
    }

    /**
     * 上传图片
     * @param uploadFileRequest
     * @return
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws UnsupportedEncodingException
     */
    public String uploadFile(UploadFileRequest uploadFileRequest) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, UnsupportedEncodingException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.uploadFile(),
                uploadFileRequest,
                token
        );
        return responseBody;
    }

    /**
     * 创建商店
     * @param createShopRequest
     * @return
     * @throws NoSuchMethodException
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public String createShop(CreateShopRequest createShopRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.createShop(),
                createShopRequest,
                token
        );
        return responseBody;
    }

    /**
     * 获取可使用的渠道
     * @param getAvailableProductListRequest
     * @return
     * @throws NoSuchMethodException
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<Product> getAvailableProductList(GetAvailableProductListRequest getAvailableProductListRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getAvailableProductList(),
                getAvailableProductListRequest,
                token
        );
        Response response = GsonUtil.GsonToBean(responseBody, Response.class);
        System.out.println(response.getData());
        List<Product> products = GsonUtil.GsonToList(response.getData(), Product.class);
        return products;
    }

    /**
     * 查询订单价格 距离
     * @param getOrderPriceRequest
     * @return
     * @throws NoSuchMethodException
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Map<String, String> getOrderPrice(GetOrderPriceRequest getOrderPriceRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getOrderPrice(),
                getOrderPriceRequest,
                token
        );
        Response response = GsonUtil.GsonToBean(responseBody, Response.class);
        Map<String, Object> map = GsonUtil.GsonToMaps(response.getData());
        int totalPrice = (int) Double.parseDouble(GsonUtil.GsonToMaps(map.get("price_info").toString()).get("total_price").toString());
        int payPrice = (int) Double.parseDouble(GsonUtil.GsonToMaps(map.get("price_info").toString()).get("pay_price").toString());
        String distance = map.get("distance").toString();
        Map<String, String> result = new HashMap<>();
        result.put("totalPrice", totalPrice + "");
        result.put("distance", distance);
        result.put("payPrice", payPrice + "");
        result.put("order_price_detail_json", map.get("order_price_detail_json").toString());
        return result;
    }

    public String createOrder(CreateOrderRequest createOrderRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.createOrder(),
                createOrderRequest,
                token
        );
        return responseBody;
    }

    public String addTips(AddTipsRequest addTipsRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {

        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.addTips(),
                addTipsRequest,
                token
        );
        return responseBody;
    }

    public Map<String, Object> getOrderDetail(GetOrderDetailRequest getOrderDetailRequest) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, UnsupportedEncodingException {

        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getOrderDetail(),
                getOrderDetailRequest,
                token
        );

        Response response = GsonUtil.GsonToBean(responseBody, Response.class);
        Map<String, Object> orderDetail = GsonUtil.GsonToMaps(response.getData());
        int orderStatus = new Double(orderDetail.get("order_status") + "").intValue();
        int orderReasonCode = new Double(orderDetail.get("order_reason_code") + "").intValue();
        orderDetail.put("order_status", orderStatus);
        orderDetail.put("order_reason_code", orderReasonCode);
        return orderDetail;
    }

    public String getCancelPrice(GetCancelPriceRequest getOrderDetailRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.getCancelPrice(),
                getOrderDetailRequest,
                token
        );

        return responseBody;
    }

    public String cancelOrder(CancelOrderRequest cancelOrderRequest) throws NoSuchMethodException, UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setTime(System.currentTimeMillis() / 1000 + "");
        String token = getToken(getTokenRequest);
        String responseBody = HttpUtil.doRequest(
                this,
                ApiUrlConstant.cancelOrder(),
                cancelOrderRequest,
                token
        );

        return responseBody;
    }
}
