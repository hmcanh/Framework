package com.rikkei.service;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rikkei.entity.Account;
import com.rikkei.form.AccountFormForCreating;
import com.rikkei.form.AccountFormForUpdating;
public interface IAccountService extends  UserDetailsService {
public List<Account> getAllAccount();
public Account getAccountById(short id);
//
// public Account getAccountByName(String name);
//
Account getAccountByUsername(String username);

public void createAccount(AccountFormForCreating form);
public void updateAccount(short id, AccountFormForUpdating form);
public void deleteAccount(short id);
//
// public boolean isAccountExistsByID(short id);
//
// public boolean isAccountExistsByName(String name);
}
