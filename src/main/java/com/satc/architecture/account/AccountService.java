package com.satc.architecture.account;

import com.satc.architecture.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {


    /**
     * Validate business integrity
     * @param newAccount
     */
    public void validadeBusiness(AccountRepresentation.CreateAccount newAccount) {

        if(!newAccount.getPassword().equals(newAccount.getPasswordConfirmation())) {
            throw new BusinessException("A senha e a confirmação não são iguais");
        }

    }
}
