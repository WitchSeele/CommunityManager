package com.common;

import com.utils.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionHelper {

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        return request;
    }

    public static String getToken() {
        String token = getRequest().getHeader("accessToken");
        if (StringUtils.isEmpty(token)) {
            token = getRequest().getParameter("accessToken");
        }
        return token;
    }
}
