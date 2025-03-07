package com.KunalTTNSpringApp.Restful_Assignment_1.Services;

import com.KunalTTNSpringApp.Restful_Assignment_1.GlobalExceptions.UserNotFoundException;
import com.KunalTTNSpringApp.Restful_Assignment_1.Models.Employee;
import com.KunalTTNSpringApp.Restful_Assignment_1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeByID(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByID(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User ID " + id + " not found"));
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        if (updatedEmployee == null) {
            throw new IllegalArgumentException("Updated employee details cannot be null.");
        }
        return employeeRepository.findById(id)
                .map(employee -> {
                    if (updatedEmployee.getName() != null) {
                        employee.setName(updatedEmployee.getName());
                    }
                    if (updatedEmployee.getAge() != null) {
                        employee.setAge(updatedEmployee.getAge());
                    }
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new UserNotFoundException("Employee ID " + id + " not found. Couldn't update employee."));
    }

}

