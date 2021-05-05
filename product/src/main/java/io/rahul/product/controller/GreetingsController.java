package io.rahul.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-ms/greetings")
public class GreetingsController {


    @Autowired
    private Environment env;

    @GetMapping("/")
    public String greet(){
        return "Greetings from product-ms at port " + env.getProperty("local.server.port") + " and instance id " + env.getProperty("eureka.instance.instance-id");
    }
}
