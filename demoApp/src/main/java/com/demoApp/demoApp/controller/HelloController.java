/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoApp.demoApp.controller;


import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author davoudnasrabadi
 */
@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String helloWorld(){
        return welcomeMessage;
    }
    
    @GetMapping("/second")
    public String hello2(){
        return "Welcome to second page dd";
    } 
}
