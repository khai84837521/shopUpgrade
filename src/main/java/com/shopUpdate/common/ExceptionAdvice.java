package com.shopUpdate.common;

import com.shopUpdate.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    private static final String MAIN = "/main";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public String handleException(BaseException ex, Model model) {
        logger.error("Exception 발생 : {}", ex.getMessage());
        model.addAttribute("msg", ex.getMessage());
        model.addAttribute("url", ex.getUrl() != null ? ex.getUrl() : MAIN);
        return "/msgBox";
    }
}
