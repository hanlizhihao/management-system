package com.changjiang;

import com.changjiang.common.utils.RequestUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hanlizhi
 * @create 2017-10-25 11:03
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "customer-error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) throws Exception {
        if (RequestUtil.isAjaxRequest(req)) {
            try {
                log.error("ajax error",e);
                PrintWriter writer = response.getWriter();
                writer.write(e.getMessage());
                writer.flush();
            } catch (IOException ex) {
                log.error("GlobalExceptionHandler PrintWriter",ex);
            }
            return new ModelAndView();
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL().toString());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }

    }
}
