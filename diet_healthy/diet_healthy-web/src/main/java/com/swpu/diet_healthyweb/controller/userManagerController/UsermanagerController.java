package com.swpu.diet_healthyweb.controller.userManagerController;

import com.swpu.diet_healthydomain.Page;
import com.swpu.diet_healthydomain.Student;
import com.swpu.diet_healthyservice.StudentManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsermanagerController {
    @Resource
    private StudentManagerService studentManagerService;

    /**
     * 展示用户信息
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/checkStudent/{currentPage}","/checkStudent"})
    public String getFoodManager(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        List<Student> students = studentManagerService.checkAllStudent((currentPage-1)*perList, perList);
        int count = studentManagerService.getAllStudentCount();
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        Page<Student> page = new Page<>(currentPage, pageCount, students);
        request.getSession().setAttribute("searchStudents", page);
        request.getSession().setAttribute("currentHtml", "userManagerHtmls/studentManagerShow.html");
        request.getSession().setAttribute("currentFrame", "student");
        return "userManager";
    }

    /**
     * 检查手机号是否被注册
     * @param student
     * @return
     */
    public boolean checkName(Student student){
        return studentManagerService.checkStudentPhone(student);
    }

    /**
     * 检查昵称是否存在
     * @param student
     * @return
     */
    public boolean checkNickName(Student student){
        return studentManagerService.checkStudentNickName(student);
    }
    /**
     * 增加用户
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String> addFlavor(@RequestBody Student student) {
        Map<String,String> map = new HashMap<>();
        boolean f = checkName(student);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        f = checkNickName(student);
        if(!f) {
            map.put("status", "false2");
            return map;
        }
        boolean flag = studentManagerService.addStudent(student);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, Boolean>  delStudent(@RequestParam int id) {
        Map<String,Boolean> map = new HashMap<>();
        boolean flag = studentManagerService.delStudent(id);
        map.put("status", flag);
        return map;
    }

    /**
     * 修改用户
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Map<String, String>  modifyStudent(@RequestBody Student student) {
        Map<String,String> map = new HashMap<>();
        boolean f = checkName(student);
        if(!f) {
            map.put("status", "false");
            return map;
        }
        f = checkNickName(student);
        if(!f) {
            map.put("status", "false2");
            return map;
        }
        boolean flag = studentManagerService.modifyStudent(student);
        if(flag) {
            map.put("status", "ok");
        }else {
            map.put("status", "false1");
        }
        return map;
    }

    /**
     * 搜索用户
     * @param student
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping(value = {"/searchStudent/{currentPage}","/searchStudent"})
    public String searchCook(Student student, HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) Integer currentPage) {
        /**
         * 存储查询条件
         */
        if (student.getId() == null && student.getS_id() == null && student.getCreation() == null &&
                student.getGrade() == null && student.getModified() == null && student.getNick_name() == null &&
                student.getPhone() == null && student.getSex() == null && student.getReal_name() == null &&
                student.getSchool() == null){
            student =(Student) request.getSession().getAttribute("searchStudentMsg");
        }else{
            if ("性别（可选）".equals(student.getSex())) {
                student.setSex(null);
            }
            request.getSession().setAttribute("searchStudentMsg", student);
        }
        if(currentPage == null) {
            currentPage = 1;
        }
        int perList = 5;
        student.setStart((currentPage - 1) * perList);
        student.setEnd(perList);
        List<Student> students = studentManagerService.searchStudent(student);
        int count = studentManagerService.searchStudentCount(student);
        int pageCount=count % perList == 0 ? count / perList : count / perList + 1;
        if (pageCount == 0){
            pageCount = 1;
        }
        Page<Student> page = new Page<>(currentPage, pageCount, students);
        request.getSession().setAttribute("searchStudentResult", page);
        request.getSession().setAttribute("currentHtml", "userManagerHtmls/studentManagerSearch.html");
        request.getSession().setAttribute("currentFrame", "searchStudentResult");
        return "userManager";
    }




}
