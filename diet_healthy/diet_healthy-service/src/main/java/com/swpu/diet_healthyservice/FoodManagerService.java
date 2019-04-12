package com.swpu.diet_healthyservice;

import com.swpu.diet_healthydomain.Cook;
import com.swpu.diet_healthydomain.F_c;
import com.swpu.diet_healthydomain.Flavor;
import com.swpu.diet_healthydomain.Food;

import java.util.List;

public interface FoodManagerService {
    List<Flavor> checkAllFlavor(int startIndex, int perList);
    int getFlavorCount();
    boolean deleteFlavor(Integer id);
    boolean modifyFlavor(Flavor flavor);
    Flavor checkFlavorName(Flavor flavor);
    boolean addFlavor(Flavor flavor);
    Flavor searchFlavor(Flavor flavor);
    List<Food> checkAllFood(int startIndex, int perList);
    int getFoodCount();
    boolean deleteFood(Integer id);
    Food checkFoodName(Food food);
    boolean modifyFood(Food food);
    boolean addFood(Food food);
    List<Cook> getCooksofFood(int id);
    boolean delCookOfFood(F_c f_c);
    boolean addCookOfFood(F_c f_c);
    boolean checkCookOfFood(Integer id);
    boolean checkCookOfFood1(Integer cook_id, Integer food_id);
    List<Food> searchFood(Food food);
    int searchFoodCount(Food food);
    List<Cook> checkAllCook(int startIndex, int perList);
    int getCookCount();
    Cook checkCookName(Cook cook);
    boolean addCook(Cook cook);
    boolean deleteCook(Integer id);
    boolean modifyCook(Cook cook);
    List<Food> getFoodsOfCook(Integer id);
    boolean checkFoodOfCook(Integer id);
    List<Cook> searchCook(Cook cook);
    int searchCookCount(Cook cook);
    Food showFood(Integer id);
    Cook showCook(Integer id);
    int addFoodPicture(Food food);
    int addCookPicture(Cook cook);
    boolean updateCookDate(int id);
    boolean updateFoodDate(int id);
}
