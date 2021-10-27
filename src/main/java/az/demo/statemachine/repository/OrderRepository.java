package az.demo.statemachine.repository;

import az.demo.statemachine.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
