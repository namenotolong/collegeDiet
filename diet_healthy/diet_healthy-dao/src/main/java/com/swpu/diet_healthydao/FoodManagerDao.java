package com.swpu.diet_healthydao;

import com.swpu.diet_healthydomain.Cook;
import com.swpu.diet_healthydomain.F_c;
import com.swpu.diet_healthydomain.Flavor;
import com.swpu.diet_healthydomain.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodManagerDao {
    List<Flavor> checkAllFlavor(@Param("startIndex") int startIndex, @Param("perList") int perList);
    int getFlavorCount();
    int deleteFlavor(Integer id);
    int modifyFlavor(Flavor flavor);
    Flavor checkFlavorName(Flavor flavor);
    int addFlavor(Flavor flavor);
    Flavor searchFlavor(Flavor flavor);
    List<Food> checkAllFood(@Param("startIndex") int startIndex, @Param("perList") int perList);
    int getFoodCount();
    int deleteFood(Integer id);
    Food checkFoodName(Food food);
    int modifyFood(Food food);
    int addFood(Food food);
    List<Cook> getCooksofFood(int id);
    int delCookOfFood(F_c f_c);
    int addCookOfFood(F_c f_c);
    Cook checkCookOfFood(@Param("id") Integer id);
    F_c checkCookOfFood1(@Param("cook_id") Integer cook_id, @Param("food_id") Integer food_id);
    List<Food> searchFood(Food food);
    int searchFoodCount(Food food);
    List<Cook> checkAllCook(@Param("startIndex") int startIndex, @Param("perList") int perList);
    int getCookCount();
    int addCook(Cook cook);
    Cook checkCookName(Cook cook);
    int deleteCook(Integer id);
    int modifyCook(Cook cook);
    List<Food> getFoodsOfCook(Integer id);
    Food checkFoodOfCook(@Param("id") Integer id);
    List<Cook> searchCook(Cook cook);
    int searchCookCount(Cook cook);
    Food showFood(Integer id);
    Cook showCook(Integer id);
    int addFoodPicture(Food food);
    int addCookPicture(Cook cook);
    int updateCookDate(int id);
    int updateFoodDate(int id);
}
