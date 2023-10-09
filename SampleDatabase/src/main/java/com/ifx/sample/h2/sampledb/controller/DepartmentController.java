package com.ifx.sample.h2.sampledb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifx.sample.h2.sampledb.entity.Department;
import com.ifx.sample.h2.sampledb.service.DepartmentService;

@RestController
public class DepartmentController {
    @Autowired private DepartmentService departmentService;
 
    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
        @Validated @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }
 
    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
 
    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
            department, departmentId);
    }
 
    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
            departmentId);
        return "Deleted Successfully";
    }
}
