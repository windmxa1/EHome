package com.siyann.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object ajaxException(HttpServletRequest req, Exception e) {
//        ErrorInfo<String> errInfo = new ErrorInfo<String>();
//        errInfo.setCode(ErrorInfo.ERROR);
//        errInfo.setMessage(e.getMessage());
//        errInfo.setUrl(req.getRequestURI().toString());
//        errInfo.setData("some data");
//        return errInfo;

        return null;
    }
}
