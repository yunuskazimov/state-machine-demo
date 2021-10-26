package az.demo.statemachine.service.impl;


import az.demo.statemachine.model.EmployeeEntity;
import az.demo.statemachine.repository.EmployeeRepository;
import az.demo.statemachine.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity createCustomer(EmployeeEntity entity) {
        employeeRepository.save(entity);
        return entity;
    }

    @Override
    public List<EmployeeEntity> getCustomer(Long id) {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        return entityList;
    }
}

