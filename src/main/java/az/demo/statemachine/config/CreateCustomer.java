package az.demo.statemachine.config;

import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import az.demo.statemachine.model.EmployeeEntity;
import az.demo.statemachine.model.Order;
import az.demo.statemachine.repository.EmployeeRepository;
import az.demo.statemachine.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CreateCustomer implements Action<AccountState, AccountEvent> {

    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void execute(StateContext<AccountState, AccountEvent> context) {
        Long orderId = (Long) context.getMessageHeader("HEADER_RECORD_ID");
        Order order = orderRepository.getById(orderId);

        System.out.println("E1 State action started.....");

    }
}