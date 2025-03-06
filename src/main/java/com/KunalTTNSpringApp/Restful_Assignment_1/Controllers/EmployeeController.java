package com.KunalTTNSpringApp.Restful_Assignment_1.Controllers;

import com.KunalTTNSpringApp.Restful_Assignment_1.Models.Employee;
import com.KunalTTNSpringApp.Restful_Assignment_1.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getEmployeeList()
    {
        return new ResponseEntity<>(employeeService.getEmployeeList(),HttpStatus.OK);
    }

    //        , @RequestBody Employee e
//        System.out.println(e);


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.getEmployeeByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable Integer id)
    {
        employeeService.deleteEmployeeByID(id);
        return new ResponseEntity<>("User ID "+id+" Deleted ",HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testResponse()
    {
        return "Welcome to spring boot";
    }
}
