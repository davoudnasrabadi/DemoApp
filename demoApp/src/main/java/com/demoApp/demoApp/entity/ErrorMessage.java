/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoApp.demoApp.entity;

import org.springframework.http.HttpStatus;

/**
 *
 * @author davoudnasrabadi
 */
public class ErrorMessage {
    
    private HttpStatus status;
    private String message;
    
    public ErrorMessage(){
        
    }
    public ErrorMessage(HttpStatus status,String message){
        this.status = status;
       this.message = message;
    }
    
    public HttpStatus getStatus(){
        return this.status;
    }
    public void setStatus(HttpStatus status){
        this.status = status;
    }
    
      public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
