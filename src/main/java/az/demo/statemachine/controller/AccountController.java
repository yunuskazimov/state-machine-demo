package az.demo.statemachine.controller;

import az.demo.statemachine.model.AccountEntity;
import az.demo.statemachine.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountEntity> addAccount(@RequestBody AccountEntity entity) {
        return new ResponseEntity<>(accountService.createAccount(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<AccountEntity> getAccounts() {
        return accountService.getAccounts();
    }
}
