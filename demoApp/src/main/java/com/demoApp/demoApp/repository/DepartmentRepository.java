/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demoApp.demoApp.repository;

import com.demoApp.demoApp.entity.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davoudnasrabadi
 */

@Repository  
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    public Department findByDepartmentName(String departmentName);
     public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
}
