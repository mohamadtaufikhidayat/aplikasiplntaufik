package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.Repository.dataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/home")
public class PenggunaListrikcontroller {

    @Autowired
    dataPelRepo repo;

    @Autowired
    Userrepo userrepo;

    @PostMapping("/registrasi")
    public DefaultResponse register(@RequestBody PenggunaListrikDto dto) {
        DefaultResponse<PenggunaListrikDto> respon = new DefaultResponse<>();
        Optional<PenggunaListrik> option = repo.findById(dto.getIdPengguna());
        if (option.isEmpty()) {
            respon.setPesan("Register Berhasil");
            respon.setData(dto);
            regis(dto);
        } else {
            respon.setPesan("Register Gagal Email Sudah Terdafatar");
        }
        return respon;
    }
    public PenggunaListrikDto regis(PenggunaListrikDto dto) {
        PenggunaListrik pel = convertEDTOtoEntity(dto);
        repo.save(pel);
        return convertEntitytoDTO(pel);
    }
    public PenggunaListrik convertEDTOtoEntity(PenggunaListrikDto dtoP) {
        PenggunaListrik pel = new PenggunaListrik();
        pel.setNamaPengguna(dtoP.getNamaPengguna());
        pel.setIdPengguna(dtoP.getIdPengguna());
        pel.setAlamat(dtoP.getAlamat());
        pel.setDaya(dtoP.getDaya());
        pel.setJenisPengguna(dtoP.getJenisPengguna());

        return pel;
    }
    public PenggunaListrikDto convertEntitytoDTO(PenggunaListrik lis) {
        PenggunaListrikDto dto= new PenggunaListrikDto();
        dto.setNamaPengguna(lis.getNamaPengguna());
        dto.setIdPengguna(lis.getIdPengguna());
        dto.setAlamat(lis.getAlamat());
        dto.setDaya(lis.getDaya());
        dto.setJenisPengguna(lis.getJenisPengguna());
        return dto;
    }
    @PutMapping("/{userId}/daftar_pel/{pelangganId}")
        User daftarPelangganUSer(@PathVariable Long userId, @PathVariable Long pelangganId){
        User user = userrepo.findById(userId).get();
        PenggunaListrik pelanggan = repo.findById(pelangganId).get();
        user.getDaftarPengguna().add(pelanggan);
        return userrepo.save(user);
    }

}


