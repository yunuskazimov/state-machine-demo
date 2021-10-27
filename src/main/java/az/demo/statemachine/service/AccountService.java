package az.demo.statemachine.service;


import az.demo.statemachine.model.AccountEntity;

import java.util.List;

public interface AccountService {
    AccountEntity createAccount(AccountEntity entity);

    List<AccountEntity> getAccounts();
}
