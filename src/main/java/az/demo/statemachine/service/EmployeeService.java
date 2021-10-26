package az.demo.statemachine.service;

import az.demo.statemachine.model.CustomerEntity;
import az.demo.statemachine.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createCustomer(EmployeeEntity entity);

    List<EmployeeEntity> getCustomer(Long id);
}
