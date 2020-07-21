package com.aioe.test.demo.controller.admin;

import com.aioe.test.demo.pojo.BaseBean;
import com.aioe.test.demo.pojo.User;
import com.aioe.test.demo.service.UserService;
import com.aioe.test.demo.utils.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

import static com.aioe.test.demo.utils.Utils.md5Code;

@Controller
@RequestMapping("admin")
public class AdminController {

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
            user.setPassword(null);
            session.setAttribute("user", user);
            return "/admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名或密码不正确");
            return "redirect:/admin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
    @GetMapping("/blogs")
    public String blogs(){

        return "/admin/blogs";
    }
    @GetMapping("/blogsInput")
    public String blogsInput(){

        return "/admin/blogs-input";
    }

    @GetMapping("/types")
    public String types(){

        return "/admin/types";
    }
    @GetMapping("/typesInput")
    public String typesInput(){

        return "/admin/types-input";
    }
    @GetMapping("/SignUp")
    public String SignUp(){

        return "/admin/SignUp";
    }

    @ResponseBody
    @PostMapping("/SignUser")
    public BaseBean signUser(User user){
        BaseBean baseBean = new BaseBean();
        user.setPassword(md5Code(user.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setType(1);
        userService.insertUser(user);
        //baseBean.setDate(user);
        baseBean.setCode(200);
        baseBean.setMsg("success");
        System.out.println("success");
        return baseBean;
    }
}
