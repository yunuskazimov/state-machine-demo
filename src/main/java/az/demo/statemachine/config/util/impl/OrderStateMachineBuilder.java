package az.demo.statemachine.config.util.impl;

import az.demo.statemachine.config.util.StateMachineBuilder;
import az.demo.statemachine.config.util.internal.OrderStateChangeInterceptor;
import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;

import az.demo.statemachine.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor

@Component
public class OrderStateMachineBuilder implements StateMachineBuilder<AccountState, AccountEvent> {

    @Qualifier("orderStateMachine")
    private final StateMachineFactory<AccountState, AccountEvent> stateMachineFactory;

    private final OrderStateChangeInterceptor orderStateChangeInterceptor;
    private final OrderRepository orderRepository;

    @Override
    public void sendEvent(Long idOrder, AccountEvent accountEvent) {
        log.info("SendEvent {}, {}", idOrder, accountEvent);
        StateMachine<AccountState, AccountEvent> sm = orderRepository.findById(idOrder).map(
                order -> build(order.getId(),stateMachineFactory,orderStateChangeInterceptor,order.getAccountState())
        ).get();
        sm.sendEvent(createMessage(accountEvent, "HEADER_ORDER_ID", idOrder));
    }

    @Override
    public void sendEventWithData(Long id, AccountEvent AccountEvent, Object key, Object value) {
        log.info("not used in this stage");
    }

}
