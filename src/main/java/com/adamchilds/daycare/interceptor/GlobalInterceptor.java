package com.adamchilds.daycare.interceptor;

import com.adamchilds.daycare.entity.user.util.UserUtil;
import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>This is a utility interceptor that intercepts every page request and does some work
 * before handling the user's request.</p>
 *
 * @author Adam Childs
 */
public class GlobalInterceptor implements HandlerInterceptor {

    @Autowired
    private UserUtil userUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        // We need to check if the modelAndView is null and if it is, this is most likely due to a 404 or some other error page
        ModelMap modelMap;
        if (modelAndView == null) {
            modelAndView = new ModelAndView();

            modelMap = modelAndView.getModelMap();
        } else {
            modelMap = modelAndView.getModelMap();
        }

        exposeAttributes(modelMap);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * Exposes attributes to every request.
     */
    private void exposeAttributes(ModelMap modelMap) {
        modelMap.put("loginForm", new LoginForm());
        modelMap.put("isAuthenticated", userUtil.isUserAuthenticated());
    }

}