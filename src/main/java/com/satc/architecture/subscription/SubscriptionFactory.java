package com.satc.architecture.subscription;

import com.satc.architecture.subscription.concretes.Partner;
import com.satc.architecture.subscription.concretes.Sales;
import com.satc.architecture.subscription.concretes.TryBuy;

public class SubscriptionFactory {
    public static ISubscription getSubscriptionEntity(Subscription subscription) {
        return switch (subscription.getType()) {
            case FREE -> new Subscription(subscription);
            case TRY_BUY -> new TryBuy(subscription);
            case SALES -> new Sales(subscription);
            case PARTNER -> new Partner(subscription);
        };
    }
}
