package com.lambdaschool.webemployees.repositories;

import com.lambdaschool.webemployees.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositories extends CrudRepository<Employee, Long>
{
}
