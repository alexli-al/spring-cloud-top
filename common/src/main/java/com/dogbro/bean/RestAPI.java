package com.dogbro.bean;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @description 接口同意返回数据结构
 * @auther dogbro
 * @date 2018-11-19 16:42
 */
public class RestAPI {

    public Integer code;

    public String msg;

    public Object data;

    private  Object exp;

    public RestAPI(){}

    public RestAPI(Integer code, String msg, Object data, Object exp) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.exp = exp;
    }
    public static RestAPI buildSuccess(Object data){
        return new RestAPI(200, "success", data, null);
    }

    public static  RestAPI systemError(){
        return new RestAPI(500, "system error", "", "");
    }

    public static RestAPI systemError(Exception e){
        return new RestAPI(500, e.getMessage(),"","");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExp() {
        return exp;
    }

    public void setExp(Object exp) {
        this.exp = exp;
    }
}
