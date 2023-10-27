package com.satc.architecture.subscription;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("subscription")
@AllArgsConstructor
public class SubscriptionController {
    private SubscriptionService subscriptionService;

    @PostMapping
    @RequestMapping("create-subscription")
    public ResponseEntity createSubscription(
            @Validated @RequestBody SubscriptionRepresentation.CreateSubscription createSubscription
        ) {
        var subscription = subscriptionService.createNewSubscription(createSubscription);
        return ResponseEntity.status(201).body(subscription);
    }
}
