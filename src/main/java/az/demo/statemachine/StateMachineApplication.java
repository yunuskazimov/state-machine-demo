package az.demo.statemachine;

import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateMachineApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }
    @Autowired
    private StateMachine<AccountState, AccountEvent> stateMachine;

    @Override
    public void run(String... args) throws Exception {

        stateMachine.sendEvent(AccountEvent.CREATE_CUSTOMER);


    }
}
