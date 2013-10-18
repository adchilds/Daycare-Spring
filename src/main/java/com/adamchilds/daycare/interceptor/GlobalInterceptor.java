package com.adamchilds.daycare.interceptor;

import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        // We need to check if the modelAndView is null and if it is, this is most likely due to a 404
        if (modelAndView != null) {
            ModelMap modelMap = modelAndView.getModelMap();

            modelMap.put("usingAceBootstrap", false);
            modelMap.put("loginForm", new LoginForm());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}