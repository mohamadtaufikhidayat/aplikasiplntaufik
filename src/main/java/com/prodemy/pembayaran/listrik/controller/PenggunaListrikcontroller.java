package com.prodemy.pembayaran.listrik.controller;

//<<<<<<< HEAD
//import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
//import com.prodemy.pembayaran.listrik.Repository.JenisPelangganRepo;
//import com.prodemy.pembayaran.listrik.Repository.Userrepo;
//import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
//import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
//import com.prodemy.pembayaran.listrik.model.entity.JenisPelanggan;
//=======
import com.prodemy.pembayaran.listrik.Repository.PenggunaListrikrepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.User;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
public class PenggunaListrikcontroller {

    @Autowired
//<<<<<<< HEAD
//    DataPelRepo repo;
//
//    @Autowired
//    Userrepo userrepo;
//
//    private final JenisPelangganRepo jenisPelangganRepo;
//
//    public PenggunaListrikcontroller(JenisPelangganRepo jenisPelangganRepo){
//        this.jenisPelangganRepo = jenisPelangganRepo;
//    }
//=======

    PenggunaListrikrepo repo;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    DataPelRepo repo1;


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
//<<<<<<< HEAD
//        if(jenisPelangganRepo.findById(dtoP.getIdJenis()).isPresent()){
//            JenisPelanggan jenisPelanggan =  jenisPelangganRepo.findById(dtoP.getIdJenis()).get();
//            pel.setIdJenis(jenisPelanggan);
//=======
        pel.setProvinsi(dtoP.getProvinsi());
        pel.setKota(dtoP.getKota());
        pel.setKecamatan(dtoP.getKecamatan());
        pel.setKelurahan(dtoP.getKelurahan());

        if (userrepo.findById(dtoP.getUser_id()).isPresent()) {
            User user = userrepo.findById(dtoP.getUser_id()).get();
            pel.setUser(user);
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
        }

        return pel;
    }

    public PenggunaListrikDto convertEntitytoDTO(PenggunaListrik lis) {
        PenggunaListrikDto dto = new PenggunaListrikDto();
        dto.setNamaPengguna(lis.getNamaPengguna());
        dto.setIdPengguna(lis.getIdPengguna());
        dto.setAlamat(lis.getAlamat());
        dto.setDaya(lis.getDaya());
        dto.setJenisPengguna(lis.getJenisPengguna());
//<<<<<<< HEAD
//        dto.setIdJenis(lis.getIdJenis().getIdJenis());
//        return dto;
//    }
//    @PutMapping("/{userId}/daftar_pel/{pelangganId}")
//        User daftarPelangganUSer(@PathVariable Long userId, @PathVariable Long pelangganId){
//        User user = userrepo.findById(userId).get();
//        PenggunaListrik pelanggan = repo.findById(pelangganId).get();
//        user.getDaftarPengguna().add(pelanggan);
//        return userrepo.save(user);
//    }
//
//}
//
//
//=======
        dto.setProvinsi(lis.getProvinsi());
        dto.setKota(lis.getKota());
        dto.setKecamatan(lis.getKecamatan());
        dto.setKelurahan(lis.getKelurahan());
        dto.setUser_id(lis.getUser().getNoInduk());
        return dto;
    }

    @GetMapping("/pengguna")
    public List<PenggunaListrikDto> get() {
        List<PenggunaListrik> kotaList = repo.findAll();
        List<PenggunaListrikDto> kotaDtoList = kotaList.stream().map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
        return kotaDtoList;
    }

    @GetMapping("search/{kecamatan}")
    public List<PenggunaListrikDto> search(@PathVariable String kecamatan) {
        List<PenggunaListrik> cari = repo.findByKecamatan(kecamatan);
        List<PenggunaListrikDto> kecdto = cari.stream().map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
        return kecdto;
    }

    @GetMapping("/list/{user_id}")
    public List<PenggunaListrikDto> find(@PathVariable Long user_id) {
        List<PenggunaListrik> find = repo.findByuser(user_id);
        List<PenggunaListrikDto> peng = find.stream().map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
        return peng;
    }
}

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
