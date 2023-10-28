package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {
    private AccountRepository accountRepository;

    public ISubscription createNewSubscription(SubscriptionRepresentation.CreateSubscription createSubscription) {
        var account = accountRepository.findById(createSubscription.getIdAccount());

        if (account.isEmpty()) return null;

        var newSub = new Subscription(createSubscription, account.get());

        newSub.subscribe(createSubscription.getIdAccount(), createSubscription.getPlan());

        return SubscriptionFactory.getSubscriptionEntity(newSub);
    }
}
