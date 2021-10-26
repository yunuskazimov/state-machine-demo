package az.demo.statemachine.service;


import az.demo.statemachine.model.AccountEntity;
import az.demo.statemachine.model.CustomerEntity;

import java.util.List;

public interface AccountService {
    AccountEntity createCustomer(AccountEntity entity);

    List<AccountEntity> getCustomer(Long id);
}
