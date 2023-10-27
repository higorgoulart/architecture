package com.satc.architecture.subscription.concretes;

import com.satc.architecture.subscription.Subscription;
import com.satc.architecture.subscription.behaviors.IChargeBehavior;
import com.satc.architecture.subscription.behaviors.IRenewBehavior;

public class Sales extends Subscription implements IRenewBehavior, IChargeBehavior {
    public Sales(Subscription subscription) {
        super(subscription);
    }

    @Override
    public void performRenew() {
        this.renew();
    }

    @Override
    public void performCharge() {
        this.charge();
    }

    @Override
    public void renew() {

    }

    @Override
    public void charge() {

    }
}
