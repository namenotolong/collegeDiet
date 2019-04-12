package com.swpu.diet_healthyweb.configur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swpu.diet_healthydomain.Manager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyInterceptor implements HandlerInterceptor{
	/**
	 * 拦截未登录用户
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Manager manager =(Manager) request.getSession().getAttribute("managerSession");
		/**
		 * 权限管理
		 */
		if(manager != null){
			String url = request.getRequestURI();
			String[] superPower = new String[] {"getFoodManager", "getUserManager",
					"getSuperManager", "searchManager", "delManager", "modifyManager", "addManager", "ownChange", "toSuperManager"};
			String[] studentPower = {"checkStudent","addStudent","delStudent","modifyStudent","searchStudent","managerModifyPassword",
                    "managerLoginOut","modifyManager","ownChange", "toUserManager"};
			String[] foodPower = {"checkFlavor","delFlavor","modifyFlavor","addFlavor","searchFlavor","checkFood","delFood","" +
                    "modifyFood","addFood","delCookOfFood","addCookOfFood","searchFood","checkCook","addCook","delCook",
            "modifyCook","searchCook","showFood","showCook","foodUpload","CookUpload","toFoodManager","managerModifyPassword",
                    "managerLoginOut","modifyManager","ownChange"};
            Boolean x = false;
			if(manager.getActor() == 1) {
                x = getaBoolean(url, superPower);
			} else if(manager.getActor() == 2 ) {
                x = getaBoolean(url, foodPower);
            } else {
                x = getaBoolean(url, studentPower);
            }
            if (!x){
                try {
                    Map<String, String> map = new HashMap();
                    map.put("msg", "请先登录");
                    request.getRequestDispatcher("/login.html").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                return x;
            }
			return x;
		}
		response.sendRedirect("/toManagerLogin");
		return false;
	}

    private Boolean getaBoolean(String url, String[] foodPower) throws IOException {
        for (int i = 0; i < foodPower.length; i++) {
            if(url.indexOf(foodPower[i]) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
