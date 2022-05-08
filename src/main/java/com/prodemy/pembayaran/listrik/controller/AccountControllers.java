package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.AccountRepo;
import com.prodemy.pembayaran.listrik.Repository.Saldorepo;
import com.prodemy.pembayaran.listrik.Service.SaldoService;
import com.prodemy.pembayaran.listrik.model.dto.AccountDto;
import com.prodemy.pembayaran.listrik.model.dto.AdminDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.UserDto;
import com.prodemy.pembayaran.listrik.model.entity.Account;
import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.Saldo;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("dompet")
public class AccountControllers {

    @Autowired
    AccountRepo repo;

    @Autowired
    Saldorepo sal;

    @Autowired
    SaldoService ser;

    @PostMapping("/daftar")
    public DefaultResponse daftarakun(@RequestBody AccountDto dto){
        DefaultResponse<AccountDto> respon = new DefaultResponse<>();
        Optional<Account> opsi = repo.findById(dto.getNomor());
        if(opsi.isEmpty()){
            respon.setPesan("Registrasi Berhasil");
            repo.save(convertDtotoEntity(dto));
            respon.setData(dto);
        }else{
            respon.setPesan("Registrasi Gagal Nomor Handphone Sudah Terdaftar");
            respon.setData(null);
        }
        return respon;
    }
    @GetMapping("/find-all")
    public List<AccountDto> get() {
        List<Account> kotaList = repo.findAll();
        List<AccountDto> kotaDtoList = kotaList.stream().map(this::convertEntitytoDto)
                .collect(Collectors.toList());
        return kotaDtoList;
    }
    public Account convertDtotoEntity(AccountDto dto){
        Account data = new Account();
        data.setNotel(dto.getNotel());
        data.setNomor(dto.getNomor());
        data.setNama(dto.getNama());

        return data;
    }
    public AccountDto convertEntitytoDto (Account data) {
        AccountDto dto = new AccountDto();
        dto.setNotel(data.getNotel());
        dto.setNomor(data.getNomor());
        dto.setNama(data.getNama());

        return dto;
    }


}
