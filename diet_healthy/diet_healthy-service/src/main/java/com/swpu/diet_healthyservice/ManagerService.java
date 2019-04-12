package com.swpu.diet_healthyservice;


import com.swpu.diet_healthydomain.Manager;

public interface ManagerService {
	Manager findManager(Manager manager);
	boolean managerModifyPassword(Manager manager);
}
