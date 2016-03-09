package com.reedmi.users.repos;

import com.reedmi.users.models.User;

public interface UserRepoCustom {

    User queryById(String id);

    void test();
}
