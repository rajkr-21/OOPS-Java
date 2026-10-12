
package com.example.RK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/gethello")
    public String sayHello() {
        return "Hello, World!";
    }
}
