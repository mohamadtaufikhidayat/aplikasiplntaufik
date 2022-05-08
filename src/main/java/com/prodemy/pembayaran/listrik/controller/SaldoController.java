//package com.prodemy.pembayaran.listrik.controller;
//
//import com.prodemy.pembayaran.listrik.Repository.AccountRepo;
//import com.prodemy.pembayaran.listrik.Repository.Saldorepo;
//import com.prodemy.pembayaran.listrik.Service.SaldoService;
//import com.prodemy.pembayaran.listrik.model.dto.AccountDto;
//import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
//import com.prodemy.pembayaran.listrik.model.dto.SaldoDto;
//import com.prodemy.pembayaran.listrik.model.entity.Account;
//import com.prodemy.pembayaran.listrik.model.entity.Saldo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DeadlockLoserDataAccessException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/saldo")
//public class SaldoController {
//
//    @Autowired
//    Saldorepo repo;
//
//    @Autowired
//    AccountRepo accrepo;
//
//    @Autowired
//    SaldoService ser;
//    @PostMapping("/daftar")
//    public DefaultResponse daftarsaldo(@RequestBody SaldoDto dto){
//        DefaultResponse<SaldoDto> respon = new DefaultResponse<>();
//        Optional<Saldo> opsi = repo.findByno_telpi(dto.getNo_telp());
//        if(opsi.isEmpty()){
//            respon.setPesan("Registrasi Berhasil");
//            repo.save(ser.convertDtoEntitySaldo(dto));
//            respon.setData(dto);
//        }else{
//            respon.setPesan("Registrasi Gagal Nomor Handphone Sudah Terdaftar");
//            respon.setData(null);
//        }
//        return respon;
//    }
//
//    @PostMapping("/transaksi")
//    public Saldo Trans(@RequestBody SaldoDto dto){
//        Saldo respon = ser.Transaksi(dto);
//        return respon;
//    }
//    @GetMapping("/find-all")
//    public List<SaldoDto> get() {
//        List<Saldo> kotaList = repo.findAll();
//        List<SaldoDto> kotaDtoList = kotaList.stream().map(this::converttoDto)
//                .collect(Collectors.toList());
//        return kotaDtoList;
//    }
//    public SaldoDto converttoDto(Saldo data){
//        SaldoDto dto = new SaldoDto();
//        dto.setSaldo(data.getSaldo());
//        dto.setPemasukan(data.getPemasukan());
//        dto.setPengeluaran(data.getPengeluaran());
//        dto.setNo_telp(data.getAccount().getNotel());
//        return dto;
//    }
//
//}
