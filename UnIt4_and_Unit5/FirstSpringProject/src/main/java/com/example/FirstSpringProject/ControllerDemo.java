
package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {

    @Autowired
    HelloWorld hw;

    @GetMapping("/gethello")
    public String getHelloWorld() {
        return hw.display();
    }

    @GetMapping("/{id}")
    public String getHelloWorldid(@PathVariable int id) {
        return "hello world with " + id;
    }
}
