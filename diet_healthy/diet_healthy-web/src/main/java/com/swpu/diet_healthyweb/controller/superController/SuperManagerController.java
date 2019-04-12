package com.swpu.diet_healthyweb.controller.superController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 超级管理员的控制层
 */
import com.swpu.diet_healthydomain.Manager;
import com.swpu.diet_healthydomain.Page;
import com.swpu.diet_healthyservice.SuperManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SuperManagerController {
	@Resource
	private SuperManagerService superManagerService;
	/**
	 * 获取超级管理员管理员集合
	 */
	@RequestMapping(value = {"/getSuperManager/{currentPage}","/getSuperManager"})
	public String getSuperManager(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
		List<Manager> allSuperManager = superManagerService.findAllManager().get(0);
		/**
		 * 移除当前登录的超级管理员
		 */
		Manager manager = (Manager) request.getSession().getAttribute("managerSession");
		for (Manager temp : allSuperManager) {
			if(temp.equals(manager)) {
				allSuperManager.remove(temp);
				break;
			}
		}
		if(currentPage == null) {
			currentPage = 1;
		}
		Page<Manager> page = new Page<>(currentPage, 5, allSuperManager.size());
		for (int i = 0; i < page.getPerList(); i++) {
			/**
			 * 防止数组溢出
			 */
			if((i+(page.getCurrentPage()-1)*page.getPerList()) == allSuperManager.size()){
				break;
			}
			page.getList().add(allSuperManager.get(i+(page.getCurrentPage()-1)*page.getPerList()));
		}
		/**
		 * 保证总页数大于0
		 */
		if (page.getPageCount() == 0){
			page.setPageCount(1);
		}
		request.getSession().setAttribute("currentSearchManager", page);
		/**
		 * 存储当前查询的管理员类别
		 */
		request.getSession().setAttribute("currentFind", 1);
		request.getSession().setAttribute("managerName", "超级管理员");
		return "superManager";
	}
	/**
	 * 获取菜谱管理员管理员集合
	 */
	@RequestMapping(value = {"/getFoodManager/{currentPage}","/getFoodManager"})
	public String getFoodManager(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
		List<Manager> allFoodManager = superManagerService.findAllManager().get(1);
		if(currentPage == null) {
			currentPage = 1;
		}
		Page<Manager> page = new Page<>(currentPage, 5, allFoodManager.size());
		for (int i = 0; i < page.getPerList(); i++) {
			/**
			 * 防止数组溢出
			 */
			if((i+(page.getCurrentPage()-1)*page.getPerList()) == allFoodManager.size()){
				break;
			}
			page.getList().add(allFoodManager.get(i+(page.getCurrentPage()-1)*page.getPerList()));
		}
		/**
		 * 保证总页数大于0
		 */
		if (page.getPageCount() == 0){
			page.setPageCount(1);
		}
		request.getSession().setAttribute("currentSearchManager", page);
		/**
		 * 存储当前查询的管理员类别
		 */
		request.getSession().setAttribute("currentFind", 2);
		request.getSession().setAttribute("managerName", "菜谱管理员");
		return "superManager";
	}
	/**
	 * 获取用户管理员管理员集合
	 */
	@RequestMapping(value = {"/getUserManager/{currentPage}","/getUserManager"})
	public String getUserManager(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
		List<Manager> allUserManager = superManagerService.findAllManager().get(2);
		if(currentPage == null) {
			currentPage = 1;
		}
		Page<Manager> page = new Page<>(currentPage, 5, allUserManager.size());
		for (int i = 0; i < page.getPerList(); i++) {
			/**
			 * 防止数组溢出
			 */
			if((i+(page.getCurrentPage()-1)*page.getPerList()) == allUserManager.size()){
				break;
			}
			page.getList().add(allUserManager.get(i+(page.getCurrentPage()-1)*page.getPerList()));
		}
		/**
		 * 保证总页数大于0
		 */
		if (page.getPageCount() == 0){
			page.setPageCount(1);
		}
		request.getSession().setAttribute("currentSearchManager", page);
		request.getSession().setAttribute("currentFind", 3);
		request.getSession().setAttribute("managerName", "用户管理员");
		return "superManager";		
	}
	/**
	 * 删除一个管理员
	 */
	@ResponseBody
	@RequestMapping(value = "/delManager", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, Boolean>  delManager(@RequestParam int id) {
		Map<String,Boolean> map = new HashMap<>();
		boolean flag = superManagerService.deleteManager(id);
		map.put("status", flag);
		return map;
	}
	/**
	 * 判断是否正在修改用户名，保证用户名的唯一性
	 */
	public boolean checkName(Manager manager){
		return superManagerService.findManager(manager.getName());
	}
	/**
	 * 修改管理员信息
	 */

	@ResponseBody
	@RequestMapping(value = "/modifyManager", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, String>  modifyManager(@RequestBody Manager manager) {
		Map<String,String> map = new HashMap<>();
		/**
		 * 判断是否正在修改用户名，保证用户名的唯一性
		 */
		if(manager.getName() != null) {
			boolean f = checkName(manager);
			if(!f) {
				map.put("status", "该用户名已经存在，请您换个名字");
				return map;
			}
		}
		boolean flag = superManagerService.modifyManager(manager);
		if(flag) {
			map.put("status", "修改成功");
		}else {
			map.put("status", "修改失败");
		}
		return map;
	}
	/**
	 * 注册管理员
	 */
	@ResponseBody
	@RequestMapping(value = "/addManager", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, String>  addManager(@RequestBody Manager manager) {
		Map<String,String> map = new HashMap<>();
		/**
		 * 判断增加的用户名是否已存在在新增加的角色中
		 */
		if(manager.getName() != null && manager.getActor() != 0) {
			boolean f = checkName(manager);
			if(!f) {
				map.put("status", "该用户名已经存在，请您换个名字");
				return map;
			}
		}
		boolean flag = superManagerService.addManager(manager);
		if(flag) {
			map.put("status", "添加成功");
		}else {
			map.put("status", "添加失败");
		}
		return map;
	}
	/**
	 * 超级管理员修改自己的信息
	 */
	@ResponseBody
	@RequestMapping(value = "/ownChange", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, String>  ownChange(@RequestBody Manager manager, HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> map = new HashMap<>();
		/**
		 * 判断是否正在修改用户名，保证用户名的唯一性
		 */
		if(manager.getName() != null) {
			boolean f = superManagerService.findManager(manager.getName());
			if(!f) {
				map.put("status", "该用户名已经存在，请您换个名字");
				return map;
			}
		}
		boolean flag = superManagerService.modifyManager(manager);
		if(flag) {
			map.put("status", "修改成功,请重新登陆");
			request.getSession().invalidate();
		}else {
			map.put("status", "修改失败");
		}
		return map;
	}
	/**
	 * 查找管理员
	 */
	@ResponseBody
	@RequestMapping(value = {"/searchManager"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Map<String, Manager>  searchManager(@RequestBody Manager manager,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Manager> map = new HashMap<>();
		Manager managers = superManagerService.searchManager(manager);
		if (managers == null){
			map.put("status", null);
		}else {
			map.put("status", managers);
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}
