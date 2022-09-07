package com.caict3in.server.demo.handler;

import com.caict3in.server.demo.common.CommonResponse;
import com.caict3in.server.demo.common.ErrorCode;
import com.caict3in.server.demo.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;


/**
 * RestController增强
 *
 * @author daisx
 */
@Slf4j
@RestControllerAdvice
public class RestControllerAdviceHandler implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = RestController.class;

    /**
     * 判断类是否使用了 @RestController
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE);
    }

    /**
     * 当类使用了 @RestController 就会调用这个方法
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof CommonResponse) {
            return body;
        }
        return CommonResponse.success(body);
    }

    /**
     * 异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResponse exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("Interface Path:[{}], occur to exception:[{}]", request.getServletPath(), e);
        return CommonResponse.failed(ErrorCode.B0001, e.getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数不合法异常
     * 配合 @Valid 注解
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.error("Interface Path:[{}], occur to MethodArgumentNotValidException:[{}]", request.getServletPath(), e);
        return CommonResponse.failed(ErrorCode.A0421.getCode(), defaultMessage);
    }

    /**
     * 处理空指针的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public CommonResponse exceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("Interface Path:[{}], occur to NullPointerException:[{}]", request.getServletPath(), e);
        return CommonResponse.failed(ErrorCode.B0001, "空指针的异常");
    }

    /**
     * 自定义异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    public CommonResponse exceptionHandler(HttpServletRequest request, CustomException e) {
        log.error("Interface Path:[{}], occur to CustomException:[{}]", request.getServletPath(), e);
        return CommonResponse.failed(e.getCode(), e.getMessage());
    }

}
