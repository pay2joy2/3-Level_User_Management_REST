package com.example.test.core.controller;

import com.example.test.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class PagesController {
    @Autowired
    UserServiceImpl userServicImpl;
//    @GetMapping("/")
//    public List<User> hello()
//    {
//        return userService.fetchUserList();
//    }

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
        userServicImpl.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/UpdateUser/{id}")
    public String update(@PathVariable(value = "id") int id, Model model)
    {
        User user =  userServicImpl.getId(id);
        return "Update";
    }
    @GetMapping("/deleteUser/{id}")
    public String delete()
    {
        return "redirect:/";
    }



}
