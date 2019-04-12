package com.swpu.diet_healthyweb.controller.foodManagerController;

import com.swpu.diet_healthydomain.*;
import com.swpu.diet_healthyservice.FoodManagerService;
import com.swpu.diet_healthyservice.SuperManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodManagerController {
    @Resource
    private SuperManagerService superManagerService;
    @Resource
    private FoodManagerService foodManagerService;

    /**
     * 获取当前查询的口味
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/checkFlavor/{currentPage}","/checkFlavor"})
    public String getFoodManager(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        List<Flavor> flavors = foodManagerService.checkAllFlavor((currentPage-1)*perList, perList);
        int count = foodManagerService.getFlavorCount();
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        Page<Flavor> page = new Page<>(currentPage, pageCount, flavors);
        request.getSession().setAttribute("searchFlavors", page);
        request.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerFlavor.html");
        request.getSession().setAttribute("currentFrame", "flavor");
        return "foodManager";
    }

    /**
     * 删除口味
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delFlavor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, Boolean>  delManager(@RequestParam int id) {
        Map<String,Boolean> map = new HashMap<>();
        boolean flag = foodManagerService.deleteFlavor(id);
        map.put("status", flag);
        return map;
    }

    /**
     * 修改口味的名称
     * @param flavor
     * @return
     */
    public boolean checkName(Flavor flavor){
        return foodManagerService.checkFlavorName(flavor) == null;
    }
    @ResponseBody
    @RequestMapping(value = "/modifyFlavor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  modifyManager(@RequestBody Flavor flavor) {
        Map<String,String> map = new HashMap<>();

        boolean f = checkName(flavor);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        boolean flag = foodManagerService.modifyFlavor(flavor);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }

    /**
     * 增加口味
     * @param flavor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addFlavor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  addFlavor(@RequestBody Flavor flavor) {
        Map<String,String> map = new HashMap<>();
        boolean f = checkName(flavor);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        boolean flag = foodManagerService.addFlavor(flavor);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }

    /**
     * 搜索口味
     * @param flavor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchFlavor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, Flavor>  searchFlavor(@RequestBody Flavor flavor) {
        Map<String, Flavor> map = new HashMap<>();
        Flavor flavor1 = foodManagerService.searchFlavor(flavor);
        map.put("status", flavor1);
        return map;
    }

    /**
     * 获取当前查询的食品
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/checkFood/{currentPage}","/checkFood"})
    public String checkFood(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        List<Food> food = foodManagerService.checkAllFood((currentPage-1)*perList, perList);
        int count = foodManagerService.getFoodCount();
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        /**
         * 得到食品相关的菜谱
         */
        for (Food temp :
                food) {
            List<Cook> cooks = foodManagerService.getCooksofFood(temp.getId());
            temp.setCooks(cooks);
        }
        Page<Food> page = new Page<>(currentPage, pageCount, food);
        request.getSession().setAttribute("searchFood", page);
        request.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerFood.html");
        request.getSession().setAttribute("currentFrame", "food");
        return "foodManager";
    }

    /**
     * 删除一个食品
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delFood", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, Boolean>  delFood(@RequestParam int id) {
        Map<String,Boolean> map = new HashMap<>();
        boolean flag = foodManagerService.deleteFood(id);
        map.put("status", flag);
        return map;
    }

    /**
     * 修改菜品
     * @param food
     * @return
     */
    public boolean checkName(Food food){
        return foodManagerService.checkFoodName(food) == null;
    }
    @ResponseBody
    @RequestMapping(value = "/modifyFood", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  modifyFood(@RequestBody Food food) {
        Map<String,String> map = new HashMap<>();
        boolean f = checkName(food);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        boolean flag = foodManagerService.modifyFood(food);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }
    /**
     * 增加菜品
     */
    @PostMapping("/addFood")
    public String addFood(HttpServletRequest request, HttpServletResponse response,Food food, Map map){
        String food_class = request.getParameter("kind");
        food.setKind(food_class);
        boolean f = checkName(food);
        if(!f) {
            map.put("msg", "该名称已存在");
            return "foodManager";
        }
        f = foodManagerService.addFood(food);
        if (f){
            map.put("msg", "添加成功");
            return "foodManager";
        }
        map.put("msg", "添加失败");
        return "foodManager";
    }
    /**
     * 删除一个菜品的菜谱
     */
    @ResponseBody
    @RequestMapping(value = "/delCookOfFood", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  delCookOfFood(@RequestBody F_c f_c) {
        Map<String,String> map = new HashMap<>();
        boolean flag = foodManagerService.delCookOfFood(f_c);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false");
        }
        foodManagerService.updateFoodDate(f_c.getFood_id());
        foodManagerService.updateCookDate(f_c.getCook_id());
        return map;
    }
    /**
     * 增加一个菜品的菜谱
     */
    @ResponseBody
    @RequestMapping(value = "/addCookOfFood", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  addCookOfFood(@RequestBody F_c f_c) {
        Map<String,String> map = new HashMap<>();
        int cook_id = f_c.getCook_id();
        int food_id = f_c.getFood_id();
        boolean flag = foodManagerService.checkCookOfFood(cook_id);
        if (flag){
            map.put("status", "false");
            return map;
        }
        flag = foodManagerService.checkFoodOfCook(food_id);
        if (flag){
            map.put("status", "false2");
            return map;
        }
        flag = foodManagerService.checkCookOfFood1(cook_id, f_c.getFood_id());
        if (!flag){
            map.put("status", "false1");
            return map;
        }
        flag = foodManagerService.addCookOfFood(f_c);
        foodManagerService.updateFoodDate(f_c.getFood_id());
        foodManagerService.updateCookDate(f_c.getCook_id());
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }
    /**
     * 搜索菜品
     */
    @RequestMapping(value = {"/searchFood/{currentPage}","/searchFood"})
    public String searchFood(Food food, HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        /**
         * 存储查询条件
         */
        if (food.getId() == null && food.getName() == null && food.getKind() == null){
            food =(Food) request.getSession().getAttribute("searchFoodMsg");
        }else{
            if ("请选择（可选）".equals(food.getKind())){
                food.setKind(null);
            }
            request.getSession().setAttribute("searchFoodMsg", food);
        }
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        food.setStart((currentPage - 1) * perList);
        food.setEnd(perList);
        List<Food> foods = foodManagerService.searchFood(food);
        int count = foodManagerService.searchFoodCount(food);
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        for (Food temp :
                foods) {
            List<Cook> cooks = foodManagerService.getCooksofFood(temp.getId());
            temp.setCooks(cooks);
        }
        Page<Food> page = new Page<>(currentPage, pageCount, foods);
        request.getSession().setAttribute("searchFoodResult", page);
        request.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerSearch.html");
        request.getSession().setAttribute("currentFrame", "searchFoodResult");
        return "foodManager";
    }

    /**
     * 获取当前查询的菜谱
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/checkCook/{currentPage}","/checkCook"})
    public String checkCook(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        List<Cook> cooks = foodManagerService.checkAllCook((currentPage-1)*perList, perList);
        int count = foodManagerService.getCookCount();
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        /**
         * 得到食品相关的菜谱
         */
        for (Cook temp :
                cooks) {
            List<Food> foods = foodManagerService.getFoodsOfCook(temp.getId());
            temp.setFoods(foods);
        }
        Page<Cook> page = new Page<>(currentPage, pageCount, cooks);
        request.getSession().setAttribute("searchCook", page);
        request.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerCook.html");
        request.getSession().setAttribute("currentFrame", "cook");
        return "foodManager";
    }

    /**
     * 检查食谱名字是否存在
     * @param cook
     * @return
     */
    public boolean checkName(Cook cook){
        return foodManagerService.checkCookName(cook) == null;
    }
    /**
     * 增加一个菜谱
     * @param request
     * @param response
     * @param cook
     * @param map
     * @return
     */
    @PostMapping("/addCook")
    public String addCook(HttpServletRequest request, HttpServletResponse response,Cook cook, Map map){
        boolean f = checkName(cook);
        if(!f) {
            map.put("msg", "该名称已存在");
            return "foodManager";
        }
        f = foodManagerService.addCook(cook);
        if (f){
            map.put("msg", "添加成功");
            return "foodManager";
        }
        map.put("msg", "添加失败");
        return "foodManager";
    }

    /**
     * 删除一个菜谱
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delCook", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, Boolean>  delCook(@RequestParam int id) {
        Map<String,Boolean> map = new HashMap<>();
        boolean flag = foodManagerService.deleteCook(id);
        map.put("status", flag);
        return map;
    }

    /**
     * 修改菜谱
     * @param cook
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyCook", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  modifyCook(@RequestBody Cook cook) {
        Map<String,String> map = new HashMap<>();
        boolean f = checkName(cook);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        boolean flag = foodManagerService.modifyCook(cook);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }

    /**
     * 搜索菜谱
     * @param cook
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/searchCook/{currentPage}","/searchCook"})
    public String searchCook(Cook cook, HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        /**
         * 存储查询条件
         */
        if (cook.getId() == null && cook.getName() == null && cook.getWeather() == null && cook.getTime() == null){
            cook =(Cook) request.getSession().getAttribute("searchCookMsg");
        }else{
            if ("请选择（可选）".equals(cook.getWeather())){
                cook.setWeather(null);
            }
            if ("请选择（可选）".equals(cook.getTime())){
                cook.setTime(null);
            }
            request.getSession().setAttribute("searchCookMsg", cook);
        }
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        cook.setStart((currentPage - 1) * perList);
        cook.setEnd(perList);
        List<Cook> cooks = foodManagerService.searchCook(cook);
        int count = foodManagerService.searchCookCount(cook);
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        for (Cook temp :
                cooks) {
            List<Food> foods = foodManagerService.getFoodsOfCook(temp.getId());
            temp.setFoods(foods);
        }
        Page<Cook> page = new Page<>(currentPage, pageCount, cooks);
        request.getSession().setAttribute("searchCookResult", page);
        request.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerCookSearch.html");
        request.getSession().setAttribute("currentFrame", "searchCookResult");
        return "foodManager";
    }
    /**
     * 获取菜品的详细信息
     */
    @ResponseBody
    @RequestMapping(value = "/showFood", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map showFood(@RequestParam int id){
        Map map = new HashMap();
        Food food = foodManagerService.showFood(id);
        map.put("food", food);
        return map;
    }
    /**
     * 获取菜谱的详细信息
     */
    @ResponseBody
    @RequestMapping(value = "/showCook", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map showCook(@RequestParam int id){
        Map map = new HashMap();
        Cook cook = foodManagerService.showCook(id);
        map.put("cook", cook);
        return map;
    }

    /**
     * 给食品上传图片
     * @param
     * @return
     */
    @PostMapping("/foodUpload")
    public String foodUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") int id, Map map) {
        upload(file, id, "H:\\images\\food", map, 1);
        return "foodManager";
    }
    /**
     * 给食谱上传图片
     * @param
     * @return
     */
    @PostMapping("/CookUpload")
    public String CookUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") int id, Map map) {
        upload(file, id, "H:\\images\\cook", map, 2);
        return "foodManager";
    }

    /**
     * 上传图片
     */
    private void upload(MultipartFile file, int id, String filePath, Map map, int status){
        if (file.isEmpty()) {
            map.put("msg", "上传失败，请选择文件");
        } else {
            String fileName = file.getOriginalFilename();
            String type = fileName.substring(fileName.lastIndexOf("."));
            fileName = id + type;
            File dest = new File(filePath + File.separator + fileName);
            if (dest.exists()){
                dest.delete();
            } else {
                if (status == 1){
                    Food food = new Food();
                    food.setPicture(id + ".jpg");
                    food.setId(id);
                    foodManagerService.addFoodPicture(food);
                } else if (status == 2){
                    Cook cook = new Cook();
                    cook.setPicture(id + ".jpg");
                    cook.setId(id);
                    foodManagerService.addCookPicture(cook);
                }
            }
            try {
                file.transferTo(dest);
                map.put("msg", "上传成功");
            } catch (IOException e) {
                map.put("msg", "上传失败，请选择文件");
                e.printStackTrace();
            }
        }
    }
}
