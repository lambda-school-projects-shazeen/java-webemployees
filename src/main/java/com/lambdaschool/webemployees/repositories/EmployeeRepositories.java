//POJO class - not managed by spring
package com.lambdaschool.webemployees.repositories;

import com.lambdaschool.webemployees.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositories extends CrudRepository<Employee, Long>
{
    //creating a CRUD application
    //requires the model it is connected to = Employee Class
    //data type of the primary key from Employee class but in class format long empid Long
}
