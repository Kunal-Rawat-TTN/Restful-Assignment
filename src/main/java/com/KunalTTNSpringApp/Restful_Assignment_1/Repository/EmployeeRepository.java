package com.KunalTTNSpringApp.Restful_Assignment_1.Repository;

import com.KunalTTNSpringApp.Restful_Assignment_1.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
}
