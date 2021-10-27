package az.demo.statemachine.service.impl;

import az.demo.statemachine.model.AccountEntity;
import az.demo.statemachine.repository.AccountRepository;
import az.demo.statemachine.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountEntity createAccount(AccountEntity entity) {
        accountRepository.save(entity);
        return entity;
    }

    @Override
    public List<AccountEntity> getAccounts() {
        List<AccountEntity> entityList = accountRepository.findAll();
        return entityList;
    }
}
