package com.swpu.diet_healthyservice.impl;
/**
 * 超级用户的业务
 */
import java.util.ArrayList;
import java.util.List;

import com.swpu.diet_healthydao.SuperManagerDao;
import com.swpu.diet_healthydomain.Manager;
import com.swpu.diet_healthyservice.SuperManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperManagerServiceImpl implements SuperManagerService {
	@Autowired
	private SuperManagerDao superManagerDao;
	/**
	 * 获取所有管理员并对身份进行分类,返回的索引为0是超级管理员，1是菜谱管理员，2是用户管理员
	 */
	public List<List<Manager>> findAllManager(){
		List<Manager> list = superManagerDao.findAllManager();
		List<Manager> listFood = new ArrayList<>();
		List<Manager> listUser = new ArrayList<>();
		List<Manager> listSuper = new ArrayList<>();
		List<List<Manager>> allManager = new ArrayList<>();
		for (Manager temp : list) {
			Integer identity = temp.getActor();
			if(identity == 1)
				listSuper.add(temp);
			if(identity == 2)
				listFood.add(temp);
			if(identity == 3)
				listUser.add(temp);
		}
		allManager.add(listSuper);
		allManager.add(listFood);
		allManager.add(listUser);
		return allManager;
	}
	/**
	 * 删除管理员
	 */
	@Override
	public boolean deleteManager(Integer id) {
		int flag = superManagerDao.deleteManager(id);
		return flag > 0;
	}
	/**
	 * 修改管理员的信息
	 */
	@Override
	public boolean modifyManager(Manager manager) {
		int flag = superManagerDao.modifyManager(manager);
		return flag > 0;
	}
	/**
	 * 查找正在修改或增加的用户的新用户名是否已经存在
	 */
	@Override
	public boolean findManager(String name) {
		Manager manager = superManagerDao.findManager(name);
		return manager == null;
	}
	/**
	 * 增加管理员
	 */
	@Override
	public boolean addManager(Manager manager) {
		int count = superManagerDao.addManager(manager);
		return count > 0;
	}
	@Override
	public boolean findManagerByNameAndActor(Manager manager) {
		Manager m = superManagerDao.findManagerByNameAndActor(manager);
		return m == null;
	}
	/**
	 * 查找管理员
	 */
	@Override
	public Manager searchManager(Manager manager) {
		return superManagerDao.searchManager(manager);
	}
}
