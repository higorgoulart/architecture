package com.satc.architecture.account.paymentinfo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class PaymentInfoEntity {

    @Id
    private Long id;
    @NotNull
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "id_credit_card")
    private CreditCardEntity creditCard;

    @OneToOne
    @JoinColumn(name = "id_bank_slip")
    private BankSlipEntity bankSlip;
}