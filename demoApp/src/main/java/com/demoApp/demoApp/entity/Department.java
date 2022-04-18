/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoApp.demoApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author davoudnasrabadi
 */
@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    
    @NotBlank(message="Please add dep. name")
    @Length(max=5,min=1)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    
    
    public Department(Long id,String name,String address,String code){
        this.departmentId=id;
        this.departmentName=name;
        this.departmentAddress=address;
        this.departmentCode = code;
    }
    
    public Department(){
        
    }
    
    public String toString(){
        return "Department{"+
                "departmentId="+departmentId+
                 "departmentName="+departmentName+"\'"+
                 "departmentAddress="+departmentAddress+"\'"+
                 "departmentCode="+departmentCode+"\'"+
                "}";
    }
    
    public Long getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId(Long id){
        this.departmentId = id;
    }
    
    public String getDepartmentName(){
        return this.departmentName;
    }
    public void setDepartmentName(String name){
        this.departmentName = name;
    }
    
    public String getDepartmentAddress(){
        return this.departmentAddress;
    }
    public void setDepartmentAddress(String address){
        this.departmentAddress = address;
    }
    
     public String getDepartmentCode(){
        return this.departmentCode;
    }
    public void setDepartmentCode(String code){
        this.departmentCode = code;
    }
    
    
    
}
