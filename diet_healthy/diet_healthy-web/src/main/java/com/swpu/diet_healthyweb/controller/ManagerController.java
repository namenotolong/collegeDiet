package com.swpu.diet_healthyweb.controller;


import javax.servlet.http.HttpSession;

import com.swpu.diet_healthydao.ManagerDao;
import com.swpu.diet_healthydomain.Manager;
import com.swpu.diet_healthyservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	/**
	 * 登陆界面
	 */
	@RequestMapping("/toManagerLogin")
	public String toManagerLogin() {
		return "login";
	}
	/**
	 * 超级用户界面
	 * @return
	 */
	@RequestMapping("/toSuperManager")
	public String toSuperManager() {
		return "superManager";
	}
	/**
	 * 食材管理员
	 * @return
	 */
	@RequestMapping("/toFoodManager")
	public String toFoodManager() {
		return "foodManager";
	}
	/**
	 * 用户管理员
	 * @return
	 */
	@RequestMapping("/toUserManager")
	public String toUserManager() {
		return "userManager";
	}
	/**
	 * 管理员退出登陆
	 */
	@GetMapping("/managerLoginOut")
	public String managerLoginOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:toManagerLogin";
	}
	@ResponseBody
	@RequestMapping(value = "/managerModifyPassword", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, String> managerModifyPassword(@RequestBody Manager manager) {
		Map<String,String> map = new HashMap<>();
		boolean flag = managerService.managerModifyPassword(manager);
		if(flag) {
			map.put("status", "修改成功");
		}else {
			map.put("status", "修改失败");
		}
		return map;
	}
}
