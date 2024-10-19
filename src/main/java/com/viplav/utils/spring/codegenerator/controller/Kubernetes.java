package com.viplav.utils.spring.codegenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Kubernetes {
    
    @GetMapping("/mykube")
    public String myKube(){
        return "Hello and welcome to my mini kube!!";
    }
}
