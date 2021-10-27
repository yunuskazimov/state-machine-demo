package az.demo.statemachine.service.impl;


import az.demo.statemachine.config.util.StateMachineBuilder;
import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {


    @Qualifier("orderStateMachine")
    private final StateMachineBuilder<AccountState, AccountEvent> stateMachineBuilder;
   public void start(Long orderId){
        stateMachineBuilder.sendEvent(orderId,AccountEvent.CREATE_CUSTOMER);
    }
}
