package com.satc.architecture.account.paymentinfo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account/{idAccount}/payment-info")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PaymentInfoController {
    private PaymentInfoService paymentInfoService;

    @PostMapping
    @RequestMapping("create")
    public ResponseEntity createNewAccountPayment(
            @Validated @RequestBody PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo,
            @PathVariable String idAccount) {
        PaymentInfoEntity paymentInfoEntity = PaymentInfoFactory.getPaymentInfoEntity(createPaymentInfo);

        return ResponseEntity.ok().build();
    }
}
