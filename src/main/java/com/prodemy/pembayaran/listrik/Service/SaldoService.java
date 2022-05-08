package com.prodemy.pembayaran.listrik.Service;

import com.prodemy.pembayaran.listrik.Repository.AccountRepo;
import com.prodemy.pembayaran.listrik.Repository.Saldorepo;
import com.prodemy.pembayaran.listrik.model.dto.AccountDto;
import com.prodemy.pembayaran.listrik.model.entity.Account;
import com.prodemy.pembayaran.listrik.model.entity.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaldoService {
    @Autowired
    Saldorepo sal;

    @Autowired
    AccountRepo repo;
    public Saldo convertDtoEntitySaldo(AccountDto dto){
        Saldo data = new Saldo();
        data.setSaldo(0L);
        data.setPemasukan(0L);
        data.setPengeluaran(0L);

        if(repo.findById(dto.getNotel()).isPresent());
        Account acc = repo.findById(dto.getNotel()).get();
        data.setAccount(acc);

        return data;
    }

}
