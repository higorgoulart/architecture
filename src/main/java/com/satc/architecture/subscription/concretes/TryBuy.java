package com.satc.architecture.subscription.concretes;

import com.satc.architecture.subscription.Subscription;
import com.satc.architecture.subscription.behaviors.IRenewBehavior;

public class TryBuy extends Subscription implements IRenewBehavior {
    public TryBuy(Subscription subscription) {
        super(subscription);
    }

    @Override
    public void performRenew() {
        this.renew();
    }

    @Override
    public void renew() {
        this.performCancel();
    }
}
