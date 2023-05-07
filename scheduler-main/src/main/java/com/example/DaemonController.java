package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaemonController {
    
    @GetMapping("/ping")
    public void ping() {
    }
}
