package com.reedmi.users.repos;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.reedmi.users.models.User;

@Resource
public class UserRepoImpl implements UserRepoCustom {

    @Autowired
    MongoTemplate mt;

    @Override
    public User queryById(String id) {
        return mt.findById(id, User.class);
    }

    @Override
    public void test() {
        System.out.println("添加自定义实现");
    }
}
