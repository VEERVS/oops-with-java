package com.example.FirstSpringProject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/Users")
public class restcontrollerdemo {
    @GetMapping("/{id}")
    public  String getUser(@PathVariable Long id) {
        return "User " + 23;
    }

    @PostMapping 
    public  String createUser(@RequestBody String user) {
        return "Created  " + user;
    }

    @PutMapping("/{id}")
    public  String updateUser(@PathVariable Long id, @RequestBody String user) {
        return "Updated " + user;
    }

    @DeleteMapping("/{id}")
    public  String deletetUser(@PathVariable Long id) {
        return "Deleted " + 23;
    }

}