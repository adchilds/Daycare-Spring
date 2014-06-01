package com.adamchilds.daycare.interceptor;

import com.adamchilds.daycare.entity.user.util.UserUtil;
import com.adamchilds.daycare.web.administration.AdministrationNavigationEnum;
import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a utility interceptor that intercepts page requests under the "/administration" URI
 * and does some work before handling the user's request.
 *
 * @author Adam Childs
 */
public class AdministrationInterceptor extends GlobalInterceptor implements HandlerInterceptor {

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
        modelAndView = getModelAndView(modelAndView);

        exposeAdministrationAttributes(modelAndView.getModelMap());

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * Exposes attributes to every request.
     */
    private void exposeAdministrationAttributes(ModelMap modelMap) {
        modelMap.addAttribute("administrationNavigation", AdministrationNavigationEnum.values());
    }

}