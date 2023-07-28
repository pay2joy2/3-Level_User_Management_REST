package com.example.test.core.controller;

import com.example.test.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagesController {
    @Autowired
    UserServiceImpl userServicImpl;
    @GetMapping("/")
    public String Homepage(Model model)
    {
        model.addAttribute("alluserlist", userServicImpl.fetchUserList());
        return "baba";
    }
    @PostMapping(value = "/addPostman")
    @ResponseBody
    public User postadd(@RequestBody User user)
    {
        return userServicImpl.addUser(user);
    }

    //@RequestBody User user
    @GetMapping("/add")
    public String add(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "AddUser";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute("user") User user)
    {
        System.out.println(user.getId());
        System.out.println(user.getName());
        userServicImpl.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/UpdateUser/{id}")
    public String update(@PathVariable(value = "id") int id, Model model)
    {
        User user =  userServicImpl.getId(id);
        model.addAttribute("user",user);
        return "Update";
    }
    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable(value = "id")int id)
    {
        userServicImpl.DeleteId(id);
        return "redirect:/";
    }
}
