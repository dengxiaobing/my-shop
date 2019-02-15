package com.dxb.my.shop.commons.dto;

/**
 * @author:deng
 * @date: 2019/2/12
 * @time: 2:51 PM
 * @email 657563945@qq.com
 */
public class BaseResult {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;


    public static BaseResult success() {
        return BaseResult.creatBaseResult("成功", STATUS_SUCCESS);
    }

    public static BaseResult fail() {

        return BaseResult.creatBaseResult("失败", STATUS_FAIL);
    }

    public static BaseResult success(String message) {

        return BaseResult.creatBaseResult(message, STATUS_SUCCESS);
    }

    public static BaseResult fail(String message) {
        return BaseResult.creatBaseResult(message, STATUS_FAIL);
    }

    private static BaseResult creatBaseResult(String message, int status) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
