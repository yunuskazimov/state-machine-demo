package az.demo.statemachine.controller;

import az.demo.statemachine.model.EmployeeEntity;
import az.demo.statemachine.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee (@RequestBody EmployeeEntity entity){
        return new ResponseEntity<>(employeeService.createEmployee(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(){
        return employeeService.getEmployees();
    }
}
