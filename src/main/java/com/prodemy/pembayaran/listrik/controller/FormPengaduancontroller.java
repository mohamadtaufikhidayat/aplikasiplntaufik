package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.PenggunaListrikrepo;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form-pengaduan")
public class FormPengaduancontroller {

    private final PenggunaListrikrepo penggunaListrikrepo;

    private final FormPengaduanrepo formPengaduanrepo;

    public FormPengaduancontroller(FormPengaduanrepo formPengaduanrepo, PenggunaListrikrepo penggunaListrikrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
    }

    @PostMapping("isi-form")
    public FormPengaduanDto insert(@RequestBody FormPengaduanDto dto) {
        FormPengaduan pengaduan = convertToEntity(dto);
        formPengaduanrepo.save(pengaduan);
        return dto;
    }

    private FormPengaduan convertToEntity(FormPengaduanDto dto){
        FormPengaduan pengaduan = new FormPengaduan();
        if(penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).isPresent()){
            PenggunaListrik penggunaListrik =  penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).get();
            pengaduan.setIdpenggunaListrik(penggunaListrik);
        }
        pengaduan.setNoPengaduan(dto.getNoPengaduan());
        pengaduan.setDeskripsi(dto.getDeskripsi());
        pengaduan.setAlamat(dto.getAlamat());
        pengaduan.setFoto(dto.getFoto());

        return pengaduan;
    }
}