package com.rikkei.repository ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rikkei.entity.Account;
public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
	public Account findByUsername(String username);
}