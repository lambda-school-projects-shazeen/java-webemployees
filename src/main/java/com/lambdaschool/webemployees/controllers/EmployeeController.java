//connects to the outside world(front-end)

package com.lambdaschool.webemployees.controllers;

import com.lambdaschool.webemployees.models.Employee;
import com.lambdaschool.webemployees.repositories.EmployeeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//creating a REST API
//controller allows us to set the routes
@RestController
public class EmployeeController
{
    //create a field
    @Autowired
    EmployeeRepositories emprepos;

    //creating a private method
    private List<Employee> findEmployees(List<Employee> myList, CheckEmployee tester)
    {
        List<Employee> tempList = new ArrayList<>();

        for (Employee e : myList)
        {
            if(tester.test(e))
            {
                tempList.add(e);
            }
        }
        return tempList;
    }

    //GET - reading data
    //annotation
    //value = route im gong to be using
    //produces = return application/json(include in the response)
    //http://localhost:2019/employees/all
    @GetMapping(value = "/employees/all", produces = {"application/json"})
    //create a method for this route to call
    //<?> - wild card entity - this method can return anything
    public ResponseEntity<?> listAllEmployees()
    {
        //created an array list
        List<Employee> myList = new ArrayList<>();
        //read all my employees from the data base
        //need to attach this controller to the data base
        //get data from repositories

        //findAll() - build into the crud repo
        //iterator() - forEachRemaining turn it into an array list
        emprepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((e1, e2) -> e1.getLname().compareToIgnoreCase(e2.getLname()));

        return new ResponseEntity<>(myList, HttpStatus.OK);
    }


    //http://localhost:2019/employees/total
    @GetMapping(value = "/employees/total", produces = {"application/json"})
    public ResponseEntity<?> reportTotalSalary()
    {
        List<Employee> myList = new ArrayList<>();
        emprepos.findAll().iterator().forEachRemaining(myList::add);

        double total = 0;

        for(Employee e : myList)
        {
            total = total + e.getSalary();
        }

        //sout tab
        System.out.println("Total salary: " + total);

        //what the front end system sees
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    //http://localhost:2019/employees/name/S
    @GetMapping(value = "/employees/name/{letter}", produces = {"application/json"})
    public ResponseEntity<?> filterByFirstName(@PathVariable char letter)
    {
        List<Employee> myList = new ArrayList<>();
        emprepos.findAll().iterator().forEachRemaining(myList::add);

        List<Employee> rtnList = findEmployees(myList, e -> e.getFname().charAt(0) == letter);
        System.out.println(rtnList);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

}
