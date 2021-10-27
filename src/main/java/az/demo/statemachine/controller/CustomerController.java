package az.demo.statemachine.controller;

import az.demo.statemachine.model.CustomerEntity;
import az.demo.statemachine.model.EmployeeEntity;
import az.demo.statemachine.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> addCustomer (@RequestBody CustomerEntity entity){
        return new ResponseEntity<>(customerService.createCustomer(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerEntity> getCustomers(){
        return customerService.getCustomers();
    }
}
