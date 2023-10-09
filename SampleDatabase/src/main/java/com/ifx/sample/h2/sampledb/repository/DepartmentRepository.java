package com.ifx.sample.h2.sampledb.repository;

import com.ifx.sample.h2.sampledb.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    
}
