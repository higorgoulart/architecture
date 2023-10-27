package com.satc.architecture.subscription;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface SubscriptionRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreateSubscription {
        @NotNull
        @Min(value = 1)
        private Long idAccount;

        @NotNull
        private Plan plan;

        @NotNull
        private Type type;
    }
}
