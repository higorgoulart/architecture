package com.satc.architecture.account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long>{


    @Query(value = "Select ?1 from AccountEntity where ?1 = ?2")
    public AccountEntity validateField(String field, String value);
}
