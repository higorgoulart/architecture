package com.satc.architecture.account;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping
    @RequestMapping("new-account")
    public ResponseEntity createNewAccount(@Validated @RequestBody AccountRepresentation.CreateAccount newAccount) {
        this.accountService.validadeBusiness(newAccount);

        AccountEntity newAccountEntity =
                this.accountService.createAccount(newAccount);

        return ResponseEntity.status(201)
                .body(AccountRepresentation.AccountResponse.from(newAccountEntity));
    }
}
