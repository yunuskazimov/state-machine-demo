package az.demo.statemachine.config;


import az.demo.statemachine.config.util.StateMachineEventAdapter;
import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;



@RequiredArgsConstructor
@EnableStateMachineFactory
@Configuration
public class StateMachineConfig extends StateMachineConfigurerAdapter<AccountState, AccountEvent>   implements
        StateMachineEventAdapter<AccountState, AccountEvent> {

    private final Action<AccountState, AccountEvent> createAccount;
    private final Action<AccountState, AccountEvent> createCustomer;


    @Override
    public void configure(StateMachineConfigurationConfigurer<AccountState, AccountEvent> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<AccountState, AccountEvent> states)
            throws Exception {
        states
                .withStates()
                .initial(AccountState.READY)
                .states(EnumSet.allOf(AccountState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<AccountState, AccountEvent> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(AccountState.READY).target(AccountState.CIF_CREATING).event(AccountEvent.CREATE_CUSTOMER).action(createCustomer)
                .and()
                .withExternal()
                .source(AccountState.CIF_CREATING).target(AccountState.CIF_CREATED)
                .and().withExternal().source(AccountState.CIF_CREATED).target(AccountState.ACCOUNT_OPENING).action(createAccount)
                .and().withExternal().source(AccountState.ACCOUNT_OPENING).target(AccountState.ACCOUNT_OPENED);

    }

    @Bean
    public StateMachineListener<AccountState, AccountEvent> listener() {
        return new StateMachineListenerAdapter<AccountState, AccountEvent>() {
            @Override
            public void stateChanged(State<AccountState, AccountEvent> from, State<AccountState, AccountEvent> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }
}