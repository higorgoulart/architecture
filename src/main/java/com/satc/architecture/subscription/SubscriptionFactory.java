package com.satc.architecture.subscription;

public class SubscriptionFactory {
    public static ISubscription getSubscriptionEntity(Subscription subscription) {
        return new Subscription(subscription);
    }
}
