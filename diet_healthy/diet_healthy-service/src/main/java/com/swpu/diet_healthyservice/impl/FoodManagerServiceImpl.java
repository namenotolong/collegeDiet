package com.swpu.diet_healthyservice.impl;

import com.swpu.diet_healthydao.FoodManagerDao;
import com.swpu.diet_healthydomain.*;
import com.swpu.diet_healthyservice.FoodManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodManagerServiceImpl implements FoodManagerService {
    @Autowired
    private FoodManagerDao foodManagerDao;

    /**
     * 口味
     * @return
     */
    @Override
    public List<Flavor> checkAllFlavor(int startIndex, int perList) {
        return foodManagerDao.checkAllFlavor(startIndex, perList);
    }

    @Override
    public boolean deleteFlavor(Integer id) {
        return foodManagerDao.deleteFlavor(id) > 0;
    }

    @Override
    public Flavor checkFlavorName(Flavor flavor) {
        return foodManagerDao.checkFlavorName(flavor);
    }

    @Override
    public boolean addFlavor(Flavor flavor) {
        return foodManagerDao.addFlavor(flavor) > 0;
    }

    @Override
    public Flavor searchFlavor(Flavor flavor) {
        return foodManagerDao.searchFlavor(flavor);
    }

    @Override
    public boolean modifyFlavor(Flavor flavor) {
        return foodManagerDao.modifyFlavor(flavor) > 0;
    }

    @Override
    public int getFlavorCount() {
        return foodManagerDao.getFlavorCount();
    }
    /**
     * 菜品
     */
    @Override
    public List<Food> checkAllFood(int startIndex, int perList) {
        return foodManagerDao.checkAllFood(startIndex, perList);
    }

    @Override
    public int getFoodCount() {
        return foodManagerDao.getFoodCount();
    }

    @Override
    public boolean deleteFood(Integer id) {
        return foodManagerDao.deleteFood(id) > 0;
    }

    @Override
    public Food checkFoodName(Food food) {
        return foodManagerDao.checkFoodName(food);
    }

    @Override
    public boolean modifyFood(Food food) {
        return foodManagerDao.modifyFood(food) > 0;
    }

    @Override
    public boolean addFood(Food food) {
        return foodManagerDao.addFood(food) > 0;
    }

    @Override
    public List<Cook> getCooksofFood(int food_id) {
        return foodManagerDao.getCooksofFood(food_id);
    }

    @Override
    public boolean delCookOfFood(F_c f_c) {
        return foodManagerDao.delCookOfFood(f_c) > 0;
    }

    @Override
    public boolean addCookOfFood(F_c f_c) {
        return foodManagerDao.addCookOfFood(f_c) > 0;
    }

    @Override
    public boolean checkCookOfFood(Integer cook_id) {
        return foodManagerDao.checkCookOfFood(cook_id) == null;
    }

    @Override
    public boolean checkCookOfFood1(Integer cook_id, Integer food_id) {
        return foodManagerDao.checkCookOfFood1(cook_id, food_id) == null;
    }

    @Override
    public List<Food> searchFood(Food food) {
        return foodManagerDao.searchFood(food);
    }

    @Override
    public int searchFoodCount(Food food) {
        return foodManagerDao.searchFoodCount(food);
    }

    @Override
    public List<Cook> checkAllCook(int startIndex, int perList) {
        return foodManagerDao.checkAllCook(startIndex, perList);
    }

    @Override
    public int getCookCount() {
        return foodManagerDao.getCookCount();
    }

    @Override
    public Cook checkCookName(Cook cook) {
        return foodManagerDao.checkCookName(cook);
    }

    @Override
    public boolean addCook(Cook cook) {
        return foodManagerDao.addCook(cook) > 0;
    }

    @Override
    public boolean deleteCook(Integer id) {
        return foodManagerDao.deleteCook(id) > 0;
    }

    @Override
    public boolean modifyCook(Cook cook) {
        return foodManagerDao.modifyCook(cook) > 0;
    }

    @Override
    public List<Food> getFoodsOfCook(Integer id) {
        return foodManagerDao.getFoodsOfCook(id);
    }

    @Override
    public boolean checkFoodOfCook(Integer id) {
        return foodManagerDao.checkFoodOfCook(id) == null;
    }

    @Override
    public List<Cook> searchCook(Cook cook) {
        return foodManagerDao.searchCook(cook);
    }

    @Override
    public int searchCookCount(Cook cook) {
        return foodManagerDao.searchCookCount(cook);
    }

    @Override
    public Food showFood(Integer id) {
        return foodManagerDao.showFood(id);
    }

    @Override
    public Cook showCook(Integer id) {
        return foodManagerDao.showCook(id);
    }

    @Override
    public int addFoodPicture(Food food) {
        return foodManagerDao.addFoodPicture(food);
    }

    @Override
    public int addCookPicture(Cook cook) {
        return foodManagerDao.addCookPicture(cook);
    }

    @Override
    public boolean updateCookDate(int id) {
        return foodManagerDao.updateCookDate(id) > 0;
    }

    @Override
    public boolean updateFoodDate(int id) {
        return foodManagerDao.updateFoodDate(id) > 0;
    }
}
