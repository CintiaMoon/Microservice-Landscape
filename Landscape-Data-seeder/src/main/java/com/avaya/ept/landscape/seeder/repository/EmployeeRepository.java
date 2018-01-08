package com.avaya.ept.landscape.seeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaya.ept.landscape.seeder.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
