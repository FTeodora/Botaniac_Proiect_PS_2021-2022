package com.botaniac.botaniacapigateway;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GatewayController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello from the gateway";
    }
}
