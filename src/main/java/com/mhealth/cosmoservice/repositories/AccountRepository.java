package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByGoogleIdIs(String googleId);
}
