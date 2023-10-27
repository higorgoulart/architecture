package com.satc.architecture.subscription.behaviors;

import com.satc.architecture.subscription.Plan;
import com.satc.architecture.subscription.Subscription;

public interface ISubscriptionBehavior {
    Subscription subscribe(Long idAccount, Plan plan);
}
