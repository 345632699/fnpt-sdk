package com.wuyi.express;

/**
 * 枚举了一些常用API操作码
 *
 * @author macro
 * @date 2019/4/19
 */
public enum ResultCode implements IErrorCode {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),
    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限"),
    /**
     * 商家配送账户余额不足
     */
    SHIP_ACCOUNT_LOW(1001, "商家配送账户余额不足"),
    /**
     * 购物车订单不存在
     */
    CART_NOT_EXIST(500, "购物车订单不存在"),
    /**
     * 最低起送金额不足
     */
    NOT_ENOUGH_PRICE(500, "起送金额不足"),
    /**
     * 超出配送范围
     */
    OVER_SHIP_LIMIT(1001, "超出配送范围");
    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
