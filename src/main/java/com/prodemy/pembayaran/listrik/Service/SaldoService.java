//package com.prodemy.pembayaran.listrik.Service;
//
//import com.prodemy.pembayaran.listrik.Repository.AccountRepo;
//import com.prodemy.pembayaran.listrik.Repository.Saldorepo;
//import com.prodemy.pembayaran.listrik.model.dto.AccountDto;
//import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
//import com.prodemy.pembayaran.listrik.model.dto.SaldoDto;
//import com.prodemy.pembayaran.listrik.model.entity.Account;
//import com.prodemy.pembayaran.listrik.model.entity.Saldo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class SaldoService {
//    @Autowired
//    Saldorepo sal;
//
//    @Autowired
//    AccountRepo repo;
//
//    public Saldo convertDtoEntitySaldo(SaldoDto dto) {
//        Saldo data = new Saldo();
//        data.setSaldo(data.getSaldo() + data.getPengeluaran() - data.getPemasukan());
//        data.setPemasukan(0L);
//        data.setPengeluaran(0L);
//
//        if (repo.findById(dto.getNo_telp()).isPresent()) ;
//        Account acc = repo.findById(dto.getNo_telp()).get();
//        data.setAccount(acc);
//
//        return data;
//    }
//
//    public Saldo convertDtoEntitySaldoTrans(SaldoDto dto) {
//        Saldo data = new Saldo();
//        data.setSaldo(data.getSaldo() + data.getPengeluaran() - data.getPemasukan());
//        data.setPemasukan(dto.getPemasukan());
//        data.setPengeluaran(dto.getPengeluaran());
//        data.setId_acc(dto.getNo_telp());
//
////        if (repo.findById(dto.getNo_telp()).isPresent()) ;
////        Account acc = repo.findById(dto.getNo_telp()).get();
////        data.setAccount(acc);
//
//        return data;
//    }
//
//    public Saldo Transaksi(SaldoDto dto) {
//        Saldo data = convertDtoEntitySaldoTrans(dto);
//        sal.save(data);
//        return data;
//    }
//}