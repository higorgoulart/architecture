package com.satc.architecture.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long>{
    boolean existsByUserName(String userName);
    boolean existsByEmail(String userName);
    boolean existsByDocument(String userName);
}
