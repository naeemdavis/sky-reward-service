package com.sky.rewards.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;





public class WebServiceHandlerExceptionResolver extends AbstractHandlerExceptionResolver implements InitializingBean {

    @SuppressWarnings("unused")
    private ObjectMapper jsonObjectMapper;


    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                    Exception ex) {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * @param jsonObjectMapper the jsonObjectMapper to set
     */
    public void setJsonObjectMapper(ObjectMapper objectMapper) {
        this.jsonObjectMapper = objectMapper;
    }


}