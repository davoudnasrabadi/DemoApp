/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demoApp.demoApp.service;

import com.demoApp.demoApp.entity.Department;
import com.demoApp.demoApp.error.DepartmentNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author davoudnasrabadi
 */
public interface DepartmentService {
    
    public Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long id) throws DepartmentNotFoundException;
    void updateDepartmentById(Long id,String departmentName,String departmentAddress, String departmentCode );
    Department getDepartmentByName(String name);
}
