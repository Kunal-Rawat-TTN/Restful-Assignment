package com.KunalTTNSpringApp.Restful_Assignment_1.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please provide a employee name")
    @Size(min=2,message = "Please provide at least 2 characters")
    private String name;

    @Min(value = 18,message = "Must be above 18")
    private Integer age;
}
