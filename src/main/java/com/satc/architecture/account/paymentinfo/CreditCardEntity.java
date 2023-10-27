package com.satc.architecture.account.paymentinfo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credit_card")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "holder")
    private String holder;

    @Column(nullable = false, name = "number")
    private String number;

    @Column(nullable = false, name = "cvv")
    private String cvv;

    @Column(nullable = false, name = "expiration_date")
    private LocalDate expirationDate;
}
