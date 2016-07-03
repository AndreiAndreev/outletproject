package ru.outletproject.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.outletproject.LoggedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interceptor adds the user to the model of every requests managed
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            LoggedUser loggedUser = LoggedUser.safeGet();
            if (loggedUser != null) {
                modelAndView.getModelMap().addAttribute("userTo", loggedUser.getUserTo());
            }
        }
    }
}
