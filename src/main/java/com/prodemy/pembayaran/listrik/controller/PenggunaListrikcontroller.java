package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.JenisPelangganRepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.JenisPelanggan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/home")
public class PenggunaListrikcontroller {

    @Autowired
    DataPelRepo repo;

    @Autowired
    Userrepo userrepo;

    private final JenisPelangganRepo jenisPelangganRepo;

    public PenggunaListrikcontroller(JenisPelangganRepo jenisPelangganRepo){
        this.jenisPelangganRepo = jenisPelangganRepo;
    }

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
        if(jenisPelangganRepo.findById(dtoP.getIdJenis()).isPresent()){
            JenisPelanggan jenisPelanggan =  jenisPelangganRepo.findById(dtoP.getIdJenis()).get();
            pel.setIdJenis(jenisPelanggan);
        }

        return pel;
    }
    public PenggunaListrikDto convertEntitytoDTO(PenggunaListrik lis) {
        PenggunaListrikDto dto= new PenggunaListrikDto();
        dto.setNamaPengguna(lis.getNamaPengguna());
        dto.setIdPengguna(lis.getIdPengguna());
        dto.setAlamat(lis.getAlamat());
        dto.setDaya(lis.getDaya());
        dto.setJenisPengguna(lis.getJenisPengguna());
        dto.setIdJenis(lis.getIdJenis().getIdJenis());
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


