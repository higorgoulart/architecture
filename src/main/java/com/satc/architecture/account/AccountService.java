package com.satc.architecture.account;

import com.satc.architecture.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    /**
     * Validate business integrity
     * @param newAccount
     */
    public void validadeBusiness(AccountRepresentation.CreateAccount newAccount) {

        if(!newAccount.getPassword().equals(newAccount.getPasswordConfirmation())) {
            throw new BusinessException("A senha e a confirmação não são iguais");
        }

        AccountEntity email =
                this.accountRepository.validateField("email", newAccount.getEmail());


        if(!Objects.isNull(email)) {
            throw new BusinessException("O email já está sendo utilizado por outra conta");
        }
    }

    public AccountEntity createAccount(AccountRepresentation.CreateAccount newAccount) {

        return this.accountRepository.save(AccountEntity.builder()
                .name(newAccount.getName())
                .document(newAccount.getDocument())
                .userName(newAccount.getUserName())
                .password(newAccount.getPassword())
                .build());

    }
}
