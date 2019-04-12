package com.swpu.diet_healthydao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.swpu.diet_healthydomain.Manager;
@Repository
public interface SuperManagerDao {
	List<Manager> findAllManager();
	int deleteManager(Integer id);
	int modifyManager(Manager manager);
	Manager findManager(@Param("name") String name);
	Manager findManagerByNameAndActor(Manager manager);
	int addManager(Manager manager);
	Manager searchManager(Manager manager);
}
