package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.TopikPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("isi-form2")
    public DefaultResponse<FormPengaduanDto> insertForm(@RequestBody FormPengaduanDto dto) {
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan entity = convertToEntity(dto);
        Optional<PenggunaListrik> optional = penggunaListrikrepo.findByIdPengguna(dto.getIdpenggunaListrik());
        Optional<TopikPengaduan> optional2 = topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik());
        if (optional.isPresent() && optional2.isPresent()) {
            formPengaduanrepo.save(entity);
            response.setPesan("Pengaduan berhasil dibuat, Kami akan segera tindaklanjuti");
            response.setData(dto);
        } else {
            response.setPesan("Nomor Meteran Atau Kode Topik Salah!");
        }
        return response;
    }


    private FormPengaduan convertToEntity(FormPengaduanDto dto) {
        FormPengaduan pengaduan = new FormPengaduan();
        if (penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).isPresent()) {
            PenggunaListrik penggunaListrik = penggunaListrikrepo.findById(dto.getIdpenggunaListrik()).get();
            pengaduan.setIdpenggunaListrik(penggunaListrik);
        }
        if (topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik()).isPresent()) {
            TopikPengaduan topikPengaduan = topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik()).get();
            pengaduan.setKodeTopik(topikPengaduan);
        }
        pengaduan.setNoPengaduan(dto.getNoPengaduan());
        pengaduan.setDeskripsi(dto.getDeskripsi());
        try {
            //  Block of code to try
            pengaduan.setAlamat(pengaduan.getIdpenggunaListrik().getAlamat());
        }
        catch(Exception e) {
            //  Block of code to handle errors
            String a = "Nomor meteran salah!";
            System.out.println(a);
        }
        pengaduan.setStatus(dto.setStatus("Pengaduan telah dibuat"));

        return pengaduan;
    }
    @PostMapping("isi-form3")
    public DefaultResponse<FormPengaduanDto> insertForm2(@RequestBody FormPengaduanDto dto) {
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan entity = convertToEntity(dto);
        FormPengaduanDto dto1 =convertToDto(entity);
        Optional<PenggunaListrik> optional = penggunaListrikrepo.findById(dto.getIdpenggunaListrik());
        Optional<TopikPengaduan> optional2 = topikPengaduanrepo.findByCodeTopik(dto.getKodeTopik());
        if (optional.isPresent() && optional2.isPresent()) {
            formPengaduanrepo.save(entity);
            response.setPesan("Pengaduan berhasil dibuat, Kami akan segera tindaklanjuti");
            response.setData(dto1);
        } else {
            response.setPesan("Nomor Meteran Atau Kode Topik Salah!");
        }
        return response;
    }

    private FormPengaduanDto convertToDto(FormPengaduan entity) {
        FormPengaduanDto dto = new FormPengaduanDto();
        dto.setNoPengaduan(entity.getNoPengaduan());
        dto.setAlamat(entity.getAlamat());
//        dto.setIdpenggunaListrik(entity.getIdpenggunaListrik());
//        dto.setKodeTopik((entity.getKodeTopik()));
        dto.setStatus(entity.getStatus());
        dto.setDeskripsi(entity.getDeskripsi());
        return dto;
    }

}

