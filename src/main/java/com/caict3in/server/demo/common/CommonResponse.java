package com.caict3in.server.demo.common;



import java.io.Serializable;

/**
 * 通用返回对象
 * @author daisx
 * @param <T>
 */
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 784254253744267038L;

    private String code;

    private String message;

    private T data;

    public CommonResponse() {
    }

    public CommonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回的数据
     */
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回的数据
     * @param  message 提示信息
     */
    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>(ErrorCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 通用失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResponse<T> failed(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }


    /**
     * 通用失败返回结果
     * @param errorCode 错误码
     * @param data 返回的数据
     */
    public static <T> CommonResponse<T> failed(ErrorCode errorCode, T data) {
        return new CommonResponse<>(errorCode.getCode(), errorCode.getMessage(), data);
    }

    /**
     * 通用失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> CommonResponse<T> failed(ErrorCode errorCode, String message) {
        return new CommonResponse<>(errorCode.getCode(), message, null);
    }

    public static <T> CommonResponse<T> failed(String errorCode, String message) {
        return new CommonResponse<>(errorCode, message, null);
    }

    /**
     * 系统执行出错
     * @param <T> T
     */
    public static <T> CommonResponse<T> systemFailed() {
        return new CommonResponse<>(ErrorCode.B0001.getCode(), ErrorCode.B0001.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResponse<T> validateFailed() {
        return new CommonResponse<>(ErrorCode.A0400.getCode(), ErrorCode.A0400.getMessage(), null);
    }
}
