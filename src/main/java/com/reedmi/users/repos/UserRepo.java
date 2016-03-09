package com.reedmi.users.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.reedmi.users.models.User;

public interface UserRepo extends MongoRepository<User, String>, UserRepoCustom {

}
