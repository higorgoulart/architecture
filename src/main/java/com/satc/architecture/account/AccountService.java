package com.satc.architecture.account;

import com.satc.architecture.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    /**
     * Validate business integrity.
     * @param newAccount
     */
    public void validadeBusiness(AccountRepresentation.CreateAccount newAccount) {
        if (!newAccount.getPassword().equals(newAccount.getPasswordConfirmation())) {
            throw new BusinessException("A senha e a confirmação não são iguais");
        }

        if (this.accountRepository.existsByUserName(newAccount.getUserName())) {
            throw new BusinessException("O usuário já está sendo utilizado por outra conta");
        }

        if (this.accountRepository.existsByEmail(newAccount.getEmail())) {
            throw new BusinessException("O e-mail já está sendo utilizado por outra conta");
        }

        if (this.accountRepository.existsByDocument(newAccount.getDocument())) {
            throw new BusinessException("O documento já está sendo utilizado por outra conta");
        }
    }

    public AccountEntity createAccount(AccountRepresentation.CreateAccount newAccount) {
        return this.accountRepository.save(AccountEntity.builder()
            .name(newAccount.getName())
            .document(newAccount.getDocument())
            .email(newAccount.getEmail())
            .userName(newAccount.getUserName())
            .password(newAccount.getPassword())
            .build());
    }
}
