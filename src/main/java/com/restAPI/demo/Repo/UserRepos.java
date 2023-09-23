package com.restAPI.demo.Repo;

import com.restAPI.demo.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepos extends MongoRepository<Users, String> {
    List<Users> findByNameContaining(String name);
}
