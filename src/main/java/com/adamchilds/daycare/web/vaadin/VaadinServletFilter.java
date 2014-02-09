package com.adamchilds.daycare.web.vaadin;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter to allow request/response pre/post-processing
 * for the Vaadin servlet
 *
 * @author Adam Childs
 * @since 1.0
 */
public class VaadinServletFilter implements Filter {
    private WebApplicationContext springApplicationContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        springApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        WebRequest webRequest = new ServletWebRequest((HttpServletRequest) request);
        WebRequestInterceptor requestFilter = (WebRequestInterceptor) springApplicationContext.getBean("globalInterceptor");

        try {
            requestFilter.preHandle(webRequest);

            chain.doFilter(request, response);

            requestFilter.afterCompletion(webRequest, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }

}