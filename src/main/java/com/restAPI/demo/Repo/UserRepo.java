package com.restAPI.demo.Repo;

import com.restAPI.demo.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users, Long> {
}
