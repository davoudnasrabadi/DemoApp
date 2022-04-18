/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoApp.demoApp.service;

import com.demoApp.demoApp.entity.Department;
import com.demoApp.demoApp.error.DepartmentNotFoundException;
import com.demoApp.demoApp.repository.DepartmentRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davoudnasrabadi
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public Department saveDepartment(Department department){
        
        return departmentRepository.save(department);
    }
    
    @Override
    public List<Department> getDepartments(){
        
        return this.departmentRepository.findAll();
    }
    
     @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException{
        
      Optional<Department>department=this.departmentRepository.findById(id);
      if(!department.isPresent()){
         throw new DepartmentNotFoundException("not found");
      }
      return department.get();
    } 
    
    @Override
    public void deleteDepartmentById(Long id)throws DepartmentNotFoundException{
      Optional<Department>department=this.departmentRepository.findById(id);
      if(!department.isPresent()){
          throw new DepartmentNotFoundException("not found");
      }
      this.departmentRepository.deleteById(id);
    }
    
    @Transactional()
    @Override
    public void updateDepartmentById(Long id,String departmentName, String departmentAddress,String departmentCode){
          Department dep = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                      "Department not found"
                    ));
            if(departmentName != null && departmentName.length()>0 && !Objects.equals(departmentName, dep.getDepartmentName())){
                dep.setDepartmentName(departmentName);
            }
            
             if(departmentAddress != null && departmentAddress.length()>0 && !Objects.equals(departmentAddress, dep.getDepartmentAddress())){
                dep.setDepartmentAddress(departmentAddress);
            }
             
            if(departmentCode != null && departmentCode.length()>0 && !Objects.equals(departmentCode, dep.getDepartmentCode())){
                dep.setDepartmentCode(departmentCode);
            }
    }
    
    @Override
    public Department getDepartmentByName(String name){
       return this.departmentRepository.findByDepartmentName(name);
    }
    
}
