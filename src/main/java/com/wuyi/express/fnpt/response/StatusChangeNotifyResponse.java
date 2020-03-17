package com.wuyi.express.fnpt.response;

public class StatusChangeNotifyResponse {
    String order_no;
    String order_status_enum;
    String update_time;
    String out_order_no;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_status_enum() {
        return order_status_enum;
    }

    public void setOrder_status_enum(String order_status_enum) {
        this.order_status_enum = order_status_enum;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getOut_order_no() {
        return out_order_no;
    }

    public void setOut_order_no(String out_order_no) {
        this.out_order_no = out_order_no;
    }
}
