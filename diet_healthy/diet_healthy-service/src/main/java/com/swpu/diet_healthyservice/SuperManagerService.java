package com.swpu.diet_healthyservice;

import java.util.List;

import com.swpu.diet_healthydomain.Manager;

public interface SuperManagerService {
	List<List<Manager>> findAllManager();
	boolean deleteManager(Integer id);
	boolean modifyManager(Manager manager);
	boolean findManager(String name);
	boolean findManagerByNameAndActor(Manager manager);
	boolean addManager(Manager manager);
	Manager searchManager(Manager manager);
}
