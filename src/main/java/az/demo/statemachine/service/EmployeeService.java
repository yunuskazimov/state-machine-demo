package az.demo.statemachine.service;

import az.demo.statemachine.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity entity);

    List<EmployeeEntity> getEmployees();
}
