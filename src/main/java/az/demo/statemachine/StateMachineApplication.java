package az.demo.statemachine;

import az.demo.statemachine.enums.AccountEvent;
import az.demo.statemachine.enums.AccountState;
import az.demo.statemachine.model.Order;
import az.demo.statemachine.service.impl.OrderService;
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
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        orderService.start(1l);


    }
}
