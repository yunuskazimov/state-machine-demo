package az.demo.statemachine.repository;

import az.demo.statemachine.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    EmployeeEntity findByPin(String pin);
}
