package io.rahul.orders.controller;

import io.rahul.orders.application.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-ms/greetings")
public class GreetingsController {

    @Autowired
    private Environment env;

    @Autowired
    IOrderService orderService;

    @GetMapping("/")
    public String greet() {
        String productMessage = orderService.getGreeting();
        String orderMessage = "Greetings from order-ms at port " + env.getProperty("local.server.port") + " and instance id " + env.getProperty("eureka.instance.instance-id");
        return productMessage + "\n" + orderMessage;
    }
}
