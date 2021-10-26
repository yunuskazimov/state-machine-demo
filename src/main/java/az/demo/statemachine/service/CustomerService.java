package az.demo.statemachine.service;

import az.demo.statemachine.model.AccountEntity;
import az.demo.statemachine.model.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity createCustomer(CustomerEntity entity);

    List<CustomerEntity> getCustomer(Long id);
}
