package az.demo.statemachine.config;

import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import az.demo.statemachine.model.EmployeeEntity;
import az.demo.statemachine.model.Order;
import az.demo.statemachine.repository.EmployeeRepository;
import az.demo.statemachine.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@RequiredArgsConstructor
@Slf4j
public class CreateCustomer implements Action<AccountState, AccountEvent> {

    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void execute(StateContext<AccountState, AccountEvent> context) {
        Long orderId = (Long) context.getMessageHeader("HEADER_ORDER_ID");
        log.info("Order id {}", orderId);
        Order order = orderRepository.getById(orderId);
        log.info("order {}", order);
        EmployeeEntity employeeEntity = employeeRepository.findByPin(order.getPin());
        log.info("employee {}", employeeEntity);

        System.out.println("E1 State action started.....");

    }
}