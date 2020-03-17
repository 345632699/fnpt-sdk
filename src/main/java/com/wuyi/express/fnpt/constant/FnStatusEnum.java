package com.wuyi.express.fnpt.constant;


import com.wuyi.express.IStatus;

public enum FnStatusEnum implements IStatus {
    /**
     * 订单已推单
     */
    ORDER_STATUS_DISPATCH(1,"订单已推单"),
    ORDER_STATUS_RECEIVE(2, "订单已被骑手接单"),
    ORDER_STATUS_REACH(2, "骑手已到店"),
    ORDER_STATUS_PICKUP(3, "骑手已取餐"),
    ORDER_STATUS_FINISH(4, "订单完成"),
    ORDER_STATUS_REFUSE(9, "订单失败(包括寄件人取消、骑手拒单、运力系统取消等)")
    ;

    private Integer code;
    private String message;

    FnStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMessage());
    }
}
