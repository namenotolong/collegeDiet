package com.swpu.diet_healthyweb.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swpu.diet_healthydomain.Manager;
import com.swpu.diet_healthyservice.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class KaptchaController {

    /**
     * 1、验证码工具
     */
    @Resource
    DefaultKaptcha defaultKaptcha;

    /**
     * 2、生成验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("rightCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 3、校对验证码以及验证登陆
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @Resource
    private ManagerService managerService;
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public String imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Map<String, Object> map) {
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        String tryCode = httpServletRequest.getParameter("yanzhengma");
        String userName = httpServletRequest.getParameter("username");
        String passWord = httpServletRequest.getParameter("password");
        //登陆身份,1---超级管理员  2---菜谱管理员  3---用户管理员
        Integer actor = Integer.parseInt(httpServletRequest.getParameter("identity"));
        if (!tryCode.equals(rightCode)) {
            map.put("msg", "验证码错误！");
            return "login";
        } else {
        	Manager manager = new Manager(userName, passWord, actor);
        	Manager manager1 = managerService.findManager(manager);
        	if(manager1 == null) {
        		map.put("msg", "账号或密码错误！");
        		return "login";
        	}else {
        		httpServletRequest.getSession().setAttribute("managerSession", manager1);
        		if(actor == 1) {
        			return "redirect:toSuperManager";
        		}
        		if(actor == 2) {
                    httpServletRequest.getSession().setAttribute("currentHtml", "foodManagerHtmls/foodManagerIndex.html");
                    httpServletRequest.getSession().setAttribute("currentFrame", "test1");
        			return "redirect:toFoodManager";
        		}
        		if(actor == 3) {
                    httpServletRequest.getSession().setAttribute("currentHtml", "userManagerHtmls/userManagerIndex.html");
                    httpServletRequest.getSession().setAttribute("currentFrame", "studentindex");
        			return "redirect:toUserManager";
        		}
        		return "login";
        	}     	
        }
    }
}

