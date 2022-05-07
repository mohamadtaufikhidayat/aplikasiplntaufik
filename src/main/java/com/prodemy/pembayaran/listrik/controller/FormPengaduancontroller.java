package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form-pengaduan")
public class FormPengaduancontroller {

    private final DataPelRepo dataPelRepo;

    private final FormPengaduanrepo formPengaduanrepo;

    public FormPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo dataPelRepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.dataPelRepo = dataPelRepo;
    }

    @PostMapping("isi-form")
    public FormPengaduanDto insert(@RequestBody FormPengaduanDto dto) {
        FormPengaduan pengaduan = convertToEntity(dto);
        formPengaduanrepo.save(pengaduan);
        return dto;
    }

    private FormPengaduan convertToEntity(FormPengaduanDto dto){
        FormPengaduan pengaduan = new FormPengaduan();
        if(dataPelRepo.findById(dto.getIdpenggunaListrik()).isPresent()){
            PenggunaListrik penggunaListrik =  dataPelRepo.findById(dto.getIdpenggunaListrik()).get();
            pengaduan.setIdpenggunaListrik(penggunaListrik);
        }
        pengaduan.setNoPengaduan(dto.getNoPengaduan());
        pengaduan.setDeskripsi(dto.getDeskripsi());
        pengaduan.setAlamat(dto.getAlamat());
        pengaduan.setFoto(dto.getFoto());

        return pengaduan;
    }
}