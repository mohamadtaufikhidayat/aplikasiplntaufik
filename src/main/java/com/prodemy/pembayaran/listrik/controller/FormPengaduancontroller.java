package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form-pengaduam")
public class FormPengaduancontroller {

    private final FormPengaduanrepo formPengaduanrepo;

    public FormPengaduancontroller(FormPengaduanrepo formPengaduanrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
    }

//    @PostMapping("/isi-form")
//    public

    public FormPengaduan convertDtoToEntity(FormPengaduanDto pengaduanDto){
        FormPengaduan entity = new FormPengaduan();
        entity.setIdpenggunaListrik(pengaduanDto.getIdpenggunaListrik());
        entity.setDeskripsi(pengaduanDto.getDeskripsi());
        return entity;
    }
    public FormPengaduanDto convertEntityToDto(FormPengaduan pengaduanEntity){
        FormPengaduanDto dto = new FormPengaduanDto();
        dto.setIdpenggunaListrik(pengaduanEntity.getIdpenggunaListrik());
        dto.setDeskripsi(pengaduanEntity.getDeskripsi());
        return dto;
    }


}