package az.demo.statemachine.service.impl;


import az.demo.statemachine.model.CustomerEntity;
import az.demo.statemachine.repository.CustomerRepository;
import az.demo.statemachine.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity createCustomer(CustomerEntity entity) {
        customerRepository.save(entity);
        return entity;
    }

    @Override
    public List<CustomerEntity> getCustomer(Long id) {
        List<CustomerEntity> entityList = customerRepository.findAll();
        return entityList;
    }
}
