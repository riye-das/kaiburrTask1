package com.restAPI.demo.Controller;


import com.restAPI.demo.Model.Users;
import com.restAPI.demo.Repo.UserRepo;
import com.restAPI.demo.Repo.UserRepos;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody Users users)
    {
        Users save = this.userRepo.save(users);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUser()
    {
        return ResponseEntity.ok(this.userRepo.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Users>> getUserById(@PathVariable long id) {
        Optional<Users> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            // User found, return it as a list
            List<Users> userList = List.of(optionalUser.get());
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            // User not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private UserRepos serverRepository;
    // GET /servers?name={name}
    @GetMapping(value = "/usersName/{name}")
    public ResponseEntity<List<Users>> getServersByName(@PathVariable String name) {
        // Find servers by name
        List<Users> servers = serverRepository.findByNameContaining(name);

        if (!servers.isEmpty()) {
            // Servers found, return them
            return new ResponseEntity<>(servers, HttpStatus.OK);
        } else {
            // No servers found, return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody Users user)
    {
        Users updateUser = userRepo.findById(id).get();
        updateUser.setName(user.getName());
        updateUser.setFramework(user.getFramework());
        updateUser.setLanguage(user.getLanguage());
        userRepo.save(updateUser);
        return "updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id)
    {
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);;
        return "Delete user with user id: "+id;
    }

}
