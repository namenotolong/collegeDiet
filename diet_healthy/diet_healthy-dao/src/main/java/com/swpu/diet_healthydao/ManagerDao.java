package com.swpu.diet_healthydao;


import com.swpu.diet_healthydomain.Manager;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerDao {
	Manager findManager(Manager manager);
	int managerModifyPassword(Manager manager);
}
