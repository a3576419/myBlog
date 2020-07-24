package com.aioe.test.demo.controller.admin;

import com.aioe.test.demo.pojo.BaseBean;
import com.aioe.test.demo.pojo.User;
import com.aioe.test.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

import static com.aioe.test.demo.utils.Utils.md5Code;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final String REDIS_SESSION_KEY = "REDIS_SESSION_KEY";
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/loginRoot";
    }

    /***
     *
     * @param username
     * @param password
     * @param session
     * @param attributes 这里不能用model，因为重定向以后model的数据会被冲掉
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
//          登陆成功
            String token = UUID.randomUUID().toString();
            //Jedis jedis = new Jedis();
            //jedis.set(REDIS_SESSION_KEY+":"+token, user.toString());
            user.setPassword(null);
            session.setAttribute("user", user);
            return "/admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码不正确");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

    @GetMapping("/blogs")
    public String blogs() {

        return "/admin/blogs";
    }

    @GetMapping("/blogsInput")
    public String blogsInput() {

        return "/admin/blogs-input";
    }

    @GetMapping("/types")
    public String types() {

        return "/admin/types";
    }

    @GetMapping("/typesInput")
    public String typesInput() {

        return "/admin/types-input";
    }

    @GetMapping("/SignUp")
    public String SignUp(Model model) {
        BaseBean baseBean = new BaseBean();
        //model.addAttribute("baseBean",baseBean);
//        modelAndView.addObject("baseBean",baseBean);
//        request.setAttribute("baseBean",baseBean);
        User user = new User();
        baseBean.setData(user);
        model.addAttribute("baseBean", baseBean);
        return "/admin/SignUp";
    }


    @PostMapping("/SignUser")
    public String signUser(User user, Model model) {
        BaseBean baseBean = new BaseBean();
        String password = user.getPassword();
        String isUsername = userService.findUsername(user.getUsername());
        if (!isUsername.equals("success")) {
            baseBean.setData(user);
            baseBean.setMsg("用户名已存在!");
            model.addAttribute("baseBean", baseBean);
//            attributes.addFlashAttribute("baseBean",baseBean);
//            attributes.addFlashAttribute("msg","用户名已存在");
            return "/admin/SignUp";
        }
        boolean isEmail = userService.findEmail(user.getEmail());
        if (isEmail) {
            user.setEmail("");
            baseBean.setData(user);
            baseBean.setMsg("该邮箱已被注册!");
            model.addAttribute("baseBean", baseBean);
            return "/admin/SignUp";
        }
        String s = md5Code(password);
        user.setPassword(s);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setType(1);
        userService.insertUser(user);
        baseBean.setData(user);
        return "redirect:/admin";
    }

    @ResponseBody
    @PostMapping("/findUsername")
    public BaseBean findUsername(User user) {
        BaseBean baseBean = new BaseBean();

//        String b = userService.findInfo(user.getUsername(),null);
//        baseBean.setCode(200);
//        baseBean.setMsg(b);
        return baseBean;
    }

    @ResponseBody
    @PostMapping("/findEmail")
    public BaseBean findEmail(User user) {
        BaseBean baseBean = new BaseBean();
//        String b = userService.findInfo(null,user.getEmail());
//        baseBean.setCode(200);
//        baseBean.setMsg(b);
        return baseBean;
    }

    @ResponseBody
    @PostMapping("/findInfo")
    public BaseBean findInfo(User user) {
        System.out.println("执行findInfo");
        BaseBean baseBean = new BaseBean();
        String b = userService.findInfo(user);
        baseBean.setCode(200);
        baseBean.setMsg(b);
        return baseBean;
    }
}
