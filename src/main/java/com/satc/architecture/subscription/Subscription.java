package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountEntity;
import com.satc.architecture.exceptions.BehaviorException;
import com.satc.architecture.subscription.behaviors.ICancelBehavior;
import com.satc.architecture.subscription.behaviors.ISubscriptionBehavior;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription implements ISubscription, ISubscriptionBehavior, ICancelBehavior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountEntity account;

    @Column(name = "plan")
    @Enumerated(value = EnumType.STRING)
    private Plan plan;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    @Column(name = "renew_date")
    private LocalDate renewDate;

    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @Column(name = "status")
    private Boolean status;

    public Subscription(Subscription subscription) {
        this.id = subscription.getId();
        this.account = subscription.getAccount();
        this.plan = subscription.getPlan();
        this.type = subscription.getType();
        this.subscriptionDate = subscription.getSubscriptionDate();
        this.renewDate = subscription.getRenewDate();
        this.cancelDate = subscription.getCancelDate();
        this.status = subscription.getStatus();
    }

    public Subscription(SubscriptionRepresentation.CreateSubscription subscription,
                        AccountEntity account) {
        this.account = account;
        this.plan = subscription.getPlan();
        this.type = subscription.getType();
        this.subscriptionDate = LocalDate.now();
        this.renewDate = this.subscriptionDate.plusDays(subscription.getPlan().getDays());
        this.cancelDate = this.cancelDate.plusDays(1);
        this.status = true;
    }

    @Override
    public Subscription performSubscription(Long idAccount, Plan plan) {
        return this.subscribe(account.getId(), plan);
    }

    @Override
    public void performRenew() {
        throw new BehaviorException("Assinatura do tipo FREE não contém renewDate");
    }

    @Override
    public void performCharge() {
        throw new BehaviorException("Assinatura do tipo FREE não contém charge");
    }

    @Override
    public void performCancel() {
        this.cancel();
    }

    @Override
    public Subscription subscribe(Long idAccount, Plan plan) {
        return new Subscription();
    }

    @Override
    public void cancel() {
        this.cancelDate = LocalDate.now();
        this.status = false;
    }
}
