package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.TopikPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/form-pengaduan")
public class FormPengaduancontroller {
    private final TopikPengaduanrepo topikPengaduanrepo;

    private final DataPelRepo penggunaListrikrepo;

    private final FormPengaduanrepo formPengaduanrepo;

    public FormPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo penggunaListrikrepo, TopikPengaduanrepo topikPengaduanrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
        this.topikPengaduanrepo = topikPengaduanrepo;
    }

    @PostMapping("isi-form")
    public FormPengaduanDto insert(@RequestBody FormPengaduanDto dto) {
        FormPengaduan pengaduan = convertToEntity(dto);
        formPengaduanrepo.save(pengaduan);
        return dto;
    }
    @PostMapping("isi-form2")
    public DefaultResponse<FormPengaduanDto> insertForm (@RequestBody FormPengaduanDto dto){
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan entity = convertToEntity(dto);
        Optional<PenggunaListrik> optional = penggunaListrikrepo.findById(dto.getIdpenggunaListrik());
        Optional<TopikPengaduan> optional2 = topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik());
        if(optional.isPresent() && optional2.isPresent()){
            formPengaduanrepo.save(entity);
            response.setPesan("Pengaduan berhasil dibuat, Kami akan segera tindaklanjuti");
            response.setData(dto);
        } else{
            response.setPesan("Nomor Meteran Atau Kode Topik Salah!");
        }
        return response;
    }

    private FormPengaduan convertToEntity(FormPengaduanDto dto){
        FormPengaduan pengaduan = new FormPengaduan();
        if(penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).isPresent()){
            PenggunaListrik penggunaListrik =  penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).get();
            pengaduan.setIdpenggunaListrik(penggunaListrik);
        }
        if(topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik()).isPresent()){
            TopikPengaduan topikPengaduan =  topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik()).get();
            pengaduan.setKodeTopik(topikPengaduan);
        }
        pengaduan.setNoPengaduan(dto.getNoPengaduan());
        pengaduan.setDeskripsi(dto.getDeskripsi());
        pengaduan.setAlamat(dto.getAlamat());
        pengaduan.setFoto(dto.getFoto());
        pengaduan.setStatus(dto.getStatus());

        return pengaduan;
    }
}