package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringProjectApplication implements CommandLineRunner {

    @Autowired
    HelloWorld hw;

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(
                        FirstSpringProjectApplication.class, args);

        System.out.println(context.getBeanDefinitionCount());

        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        hw.display();
    }
}