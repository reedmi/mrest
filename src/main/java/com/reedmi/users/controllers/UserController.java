package com.reedmi.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reedmi.users.models.User;
import com.reedmi.users.repos.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/save/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User save(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        userRepo.findOne(name);
        return userRepo.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id) {
        userRepo.delete(id);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable String id) {
        // 使用自定义实现查询
        User user = userRepo.queryById(id);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> all() {
        return userRepo.findAll();
    }
}
