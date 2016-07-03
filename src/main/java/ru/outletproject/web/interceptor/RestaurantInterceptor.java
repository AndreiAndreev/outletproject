package ru.outletproject.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.outletproject.CurrentRestaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interceptor adds the restaurant to the model of every requests managed
 */

public class RestaurantInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            CurrentRestaurant currentRestaurant = CurrentRestaurant.safeGet();
            if (currentRestaurant != null) {
                modelAndView.getModelMap().addAttribute("restaurantTo", currentRestaurant.getRestaurantTo());
            }
        }
    }
}
