package com.satc.architecture.subscription;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Plan {
    FREE(0),
    MONTHLY(30),
    ANNUALLY(365);

    private final Integer days;
}
