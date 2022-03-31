package com.botaniac.botaniacapigateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GatewayController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello from the gateway. Make sure the homepage service is running and type http://localhost:8420/Homepage to access the Homepage";
    }
}
