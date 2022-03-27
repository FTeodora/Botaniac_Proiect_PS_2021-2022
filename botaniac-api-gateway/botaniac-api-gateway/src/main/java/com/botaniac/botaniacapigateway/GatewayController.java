package com.botaniac.botaniacapigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello from the gateway";
    }
}
