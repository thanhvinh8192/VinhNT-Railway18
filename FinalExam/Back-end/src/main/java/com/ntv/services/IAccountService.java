package com.ntv.services;

import com.ntv.entities.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> findAllAccounts();

    Account getAccountByUsername(String username);

}
