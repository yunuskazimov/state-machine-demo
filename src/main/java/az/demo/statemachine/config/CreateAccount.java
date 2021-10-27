package az.demo.statemachine.config;

import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;


@Component
public class CreateAccount implements Action<AccountState, AccountEvent> {

    @Override
    public void execute(StateContext<AccountState, AccountEvent> context) {
        System.out.println("create account....");

    }
}