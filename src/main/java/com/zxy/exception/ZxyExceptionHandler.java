/*
package com.zxy.exception;

import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ZxyExceptionHandler {
    */
/**
     * BaseException 异常处理
     *//*

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, BaseException e) throws Exception {

        logger.error("error", e);

        ResultData resultData = new ResultData();

        String message = e.getMessage();
        resultData.setMsg(message);
        if (e.getCode() != null) {
            resultData.setCode(e.getCode());
        } else {
            resultData.setCode(ErrorCode.ERROR);
        }
        return resultData;
    }

    */
/**
     * ConstraintViolationException 异常处理
     *//*

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, ConstraintViolationException e) throws Exception {

        e.printStackTrace();

        ResultData resultData = new ResultData();
        resultData.setCode(ErrorCode.ERROR);
        resultData.setMsg("error");

        Map<String, String> errorMsg = new HashMap<>();
        String key = null;
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            PathImpl path = (PathImpl) constraintViolation.getPropertyPath();
            NodeImpl leafNode = path.getLeafNode();
            NodeImpl parentNode = leafNode.getParent();
            if (parentNode != null) {
                key = parentNode.getName() + ".";
            } else {
                key = "";
            }
            key += leafNode.getName();
            errorMsg.put(key, constraintViolation.getMessage());
        }

        resultData.setData(errorMsg);

        return resultData;
    }

    */
/**
     * BindException 异常处理
     *//*

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, BindException e) throws Exception {

        e.printStackTrace();

        ResultData resultData = new ResultData();
        resultData.setCode(ErrorCode.ERROR);
        resultData.setMsg("error");

        Map<String, String> errorMsg = new HashMap<>();
        String key = null;
        BindingResult result = e.getBindingResult();
        List<FieldError> list = result.getFieldErrors();

        for (FieldError error : list) {

            if (error.getObjectName() != null) {
                key = error.getObjectName() + ".";
            } else {
                key = "";
            }
            key += error.getField();
            errorMsg.put(key, error.getDefaultMessage());
        }
        resultData.setData(errorMsg);

        return resultData;
    }

    */
/**
     * MethodArgumentNotValidException 异常处理
     *//*

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException e) throws Exception {

        ResultData resultData = new ResultData();
        resultData.setCode(ErrorCode.ERROR);
        resultData.setMsg("error");

        Map<String, String> errorMsg = new HashMap<>();
        String key = null;
        BindingResult result = e.getBindingResult();
        List<FieldError> list = result.getFieldErrors();

        for (FieldError error : list) {

            if (error.getObjectName() != null) {
                key = error.getObjectName() + ".";
            } else {
                key = "";
            }
            key += error.getField();
            errorMsg.put(key, error.getDefaultMessage());
        }
        resultData.setData(errorMsg);

        return resultData;
    }

    */
/**
     * NoHandlerFoundException 异常处理
     *//*

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, NoHandlerFoundException e) throws Exception {

        e.printStackTrace();

        ResultData resultData = new ResultData();
        resultData.setCode(ErrorCode.ERROR);
        resultData.setMsg("error");
        return resultData;
    }

    */
/**
     * Exception 异常处理
     *//*

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        String message = e.getMessage();
        e.printStackTrace();
        ResultData resultData = new ResultData();
        resultData.setMsg(message);
        resultData.setCode(ErrorCode.ERROR);
        return resultData;
    }
}
*/
