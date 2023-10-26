package com.satc.architecture.account.paymentinfo;

public class PaymentInfoFactory {

    public static PaymentInfoEntity getPaymentInfoEntity(
            PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {

        return switch (createPaymentInfo.getPaymentType()) {
            case BANK_SLIP -> buildBankSlip(createPaymentInfo);
            default -> buildCreditCard(createPaymentInfo);
        };

    }

    private static PaymentInfoEntity buildCreditCard(
            PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {

        return PaymentInfoEntity.builder()
                .build();
    }

    private static PaymentInfoEntity buildBankSlip(
            PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return PaymentInfoEntity.builder().build();
    }
}
