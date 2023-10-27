package com.satc.architecture.subscription;

public interface ISubscription {
    Subscription performSubscription(Long idAccount, Plan plan);
    void performRenew();
    void performCharge();
    void performCancel();
}
