/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoApp.demoApp.controller;

import com.demoApp.demoApp.entity.Department;
import com.demoApp.demoApp.error.DepartmentNotFoundException;
import com.demoApp.demoApp.service.DepartmentService;
import com.demoApp.demoApp.service.DepartmentServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
/**
 *
 * @author davoudnasrabadi
 */

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside of save Department method of Department Controller...");
       return departmentService.saveDepartment(department);
        
    }
    
    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("Inside of get Departments method of Department Controller...");
        return departmentService.getDepartments(); 
    }
    
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException{
        LOGGER.info("Inside of get Department by id method of Department Controller...");
        return departmentService.getDepartmentById(id);
    }
     @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException{
        LOGGER.info("Inside of delete Department by id method of Department Controller...");
        this.departmentService.deleteDepartmentById(id);
        return "Department Deleted successfully";
    }
    
    @PutMapping(path="/departments/{id}")
    public String updateStudent(
      @PathVariable("id") Long id,
      @RequestBody(required=false) Department dep)
  {
      LOGGER.info("Inside of update Department by id method of Department Controller...");
      this.departmentService.updateDepartmentById(id,dep.getDepartmentName(),dep.getDepartmentAddress(),dep.getDepartmentCode());
       return "Department updated successfully";
    }
    
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
         LOGGER.info("Inside of get Department by name method of Department Controller...");
        return this.departmentService.getDepartmentByName(departmentName);
    }
}
