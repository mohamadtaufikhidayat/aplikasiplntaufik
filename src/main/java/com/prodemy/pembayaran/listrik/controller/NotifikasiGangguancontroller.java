package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/notifikasi-gangguan")
public class NotifikasiGangguancontroller {

    private final DataPelRepo dataPelRepo;

    public NotifikasiGangguancontroller(DataPelRepo dataPelRepo) {
        this.dataPelRepo = dataPelRepo;
    }

    @GetMapping("/notifikasi/{alamat}")
    public DefaultResponse<PenggunaListrikDto> getNotification(@PathVariable String alamat) {
        DefaultResponse<PenggunaListrikDto> response = new DefaultResponse<>();
        PenggunaListrik entity = new PenggunaListrik();
        PenggunaListrikDto dto = convertToDto(entity);
        Optional<PenggunaListrik> optional = dataPelRepo.findAllByAlamat(alamat);
        if (optional.isPresent()){
            response.setPesan("Ada gangguan listrik di daerah anda! Harap sabar menunngu, perbaikan akan segera dilakukan");
            response.setData(dto);
        } else{
            response.setPesan("Alamat salah! Silahkan masukkan Nama Kecamatan, Kota, dan Provinsi");
        }
        return response;
    }

    private PenggunaListrikDto convertToDto(PenggunaListrik entity) {
        PenggunaListrikDto dto = new PenggunaListrikDto();
        dto.setIdPengguna(entity.getIdPengguna());
        dto.setNamaPengguna(entity.getNamaPengguna());
        dto.setAlamat(entity.getAlamat());
        return dto;
    }


}
