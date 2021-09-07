package com.common;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MustLoginInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod;
        try {
            handlerMethod = (HandlerMethod) handler;
        } catch (Exception e) {
            return true;
        }
        if (response.getStatus() == 404) {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
            return true;
        }
        Method method = handlerMethod.getMethod();
//        MustLogin annotation = method.getAnnotation(MustLogin.class);
//        if (annotation != null) {
//            UserInfoEntity userinfoEntity1 = userService.getUserByToken();
//            if (userinfoEntity1 == null) {
//                throw new UnLoginException();
//            }
//            int[] roles = annotation.rolerequired();
//            int userrole = userinfoEntity1.getJs();
//            for (int role : roles) {
//                //todo 权限判断
//                if (role == 0 || (role == userrole)) {
//                    return true;
//                }
//            }
//            throw new DataValidateFiledException("您没有权限进行此操作");
//        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
