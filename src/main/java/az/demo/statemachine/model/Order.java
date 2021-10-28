package az.demo.statemachine.model;

import az.demo.statemachine.enums.AccountState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pin;
    private String customer;
    private String account;
    @Enumerated(EnumType.STRING)
    private AccountState accountState;

}
