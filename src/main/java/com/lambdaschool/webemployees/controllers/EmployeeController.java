//connects to the outside world(front-end)

package com.lambdaschool.webemployees.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//creating a REST API
//controller allows us to set the routes
@RestController
public class EmployeeController
{
    //GET - reading data
    //annotation
    //value = route im gong to be using
    //produces = return application/json(include in the response)
    //http://localhost:2019/employees/all
    @GetMapping(value = "/employees/all", produces = {"application/json"})
    //create a method for this route to call
    public ResponseEntity<?> getAllEmployees()
    {

    }
}
