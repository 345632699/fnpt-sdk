package com.wuyi.express.fnpt.response;

public class Product {
    Integer product_id;
    String product_name;
    Integer valid;
    String invalid_reason;
    Integer if_can_addtip;
    String message;
    String slogan;
    Integer t_indexid;
    Integer predict_duration;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getInvalid_reason() {
        return invalid_reason;
    }

    public void setInvalid_reason(String invalid_reason) {
        this.invalid_reason = invalid_reason;
    }

    public Integer getIf_can_addtip() {
        return if_can_addtip;
    }

    public void setIf_can_addtip(Integer if_can_addtip) {
        this.if_can_addtip = if_can_addtip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getT_indexid() {
        return t_indexid;
    }

    public void setT_indexid(Integer t_indexid) {
        this.t_indexid = t_indexid;
    }

    public Integer getPredict_duration() {
        return predict_duration;
    }

    public void setPredict_duration(Integer predict_duration) {
        this.predict_duration = predict_duration;
    }
}
