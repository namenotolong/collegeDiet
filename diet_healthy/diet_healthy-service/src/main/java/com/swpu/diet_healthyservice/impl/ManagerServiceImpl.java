package com.swpu.diet_healthyservice.impl;

import com.swpu.diet_healthydao.ManagerDao;
import com.swpu.diet_healthyservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.diet_healthydomain.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDao managerDao;
	/**
	 * 判断登陆的管理员是否存在
	 */
	@Override
	public Manager findManager(Manager manager) {
		return managerDao.findManager(manager);
	}

	@Override
	public boolean managerModifyPassword(Manager manager) {
		return managerDao.managerModifyPassword(manager) > 0;
	}
}
