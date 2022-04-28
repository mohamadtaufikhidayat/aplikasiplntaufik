package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.PenggunaListrikrepo;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form-pengaduam")
public class FormPengaduancontroller {

    private final PenggunaListrikrepo penggunaListrikrepo;

    private final FormPengaduanrepo formPengaduanrepo;

    public FormPengaduancontroller(FormPengaduanrepo formPengaduanrepo, PenggunaListrikrepo penggunaListrikrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
    }

    @PostMapping("/isi-form")
    public FormPengaduanDto postPengaduan(@RequestBody FormPengaduanDto formPengaduanDto){
        FormPengaduan formPengaduan = convertDtoToEntity(formPengaduanDto);
        formPengaduanrepo.save(formPengaduan);
        return formPengaduanDto;
    }


    public FormPengaduan convertDtoToEntity(FormPengaduanDto pengaduanDto){
        FormPengaduan entity = new FormPengaduan();
        entity.setNoPengaduan(pengaduanDto.getNoPengaduan());
//        entity.setIdpenggunaListrik(pengaduanDto.getIdpenggunaListrik());
        entity.setDeskripsi(pengaduanDto.getDeskripsi());
        return entity;
    }
    public FormPengaduanDto convertEntityToDto(FormPengaduan pengaduanEntity){
        FormPengaduanDto dto = new FormPengaduanDto();
//        dto.setIdpenggunaListrik(pengaduanEntity.getIdpenggunaListrik());
        dto.setDeskripsi(pengaduanEntity.getDeskripsi());
        return dto;
    }


}