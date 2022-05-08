package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.dto.AccountDto;
import com.prodemy.pembayaran.listrik.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
