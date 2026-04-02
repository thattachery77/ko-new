package com.example.category.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service", url = "http://localhost:8082")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    String getUser(@PathVariable("id") Long id);
}
