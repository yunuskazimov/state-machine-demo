package az.demo.statemachine.config.util.internal;


import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import az.demo.statemachine.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OrderStateChangeInterceptor extends StateMachineInterceptorAdapter<AccountState, AccountEvent> {

    private final OrderRepository orderRepository;

    //@Override
    public void preStateChange(State<AccountState, AccountEvent> state, Message<AccountEvent> message,
                               Transition<AccountState, AccountEvent> transition,
                               StateMachine<AccountState, AccountEvent> stateMachine) {

        Optional.ofNullable(message)
                .flatMap(
                        msg -> Optional.ofNullable(
                                (Long) msg.getHeaders().getOrDefault("HEADER_ORDER_ID",
                                        -1L))
                )
                .flatMap(orderRepository::findById)
                .ifPresent(
                        order -> {
                            order.setAccountState(state.getId());
                            orderRepository.save(order);
                        });
    }
}
