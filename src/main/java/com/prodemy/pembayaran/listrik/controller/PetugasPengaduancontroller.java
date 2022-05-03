package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Service.PengaduanService;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/petugas-pengaduan")
public class PetugasPengaduancontroller {
    private final PengaduanService pengaduanService;
    private final FormPengaduanrepo formPengaduanrepo;
    private final DataPelRepo penggunaListrikrepo;

    public PetugasPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo penggunaListrikrepo, PengaduanService pengaduanService) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
        this.pengaduanService = pengaduanService;
    }
    @PutMapping("/tindak-lanjut/{noPengaduan}")
    public int update (@PathVariable Long noPengaduan){
        return pengaduanService.updateStatusComplaint(noPengaduan);
    }

    @PutMapping("/tindak-lanjut2/{noPengaduan}")
    public DefaultResponse<FormPengaduanDto> update2 (@PathVariable Long noPengaduan){
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan entity = new FormPengaduan();
        FormPengaduanDto dto = convertToDto(entity);
        Optional<FormPengaduan> optional = formPengaduanrepo.findById(noPengaduan);
        if(optional.isPresent()){
            pengaduanService.updateStatusComplaint(noPengaduan);
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(dto);
        } else{
            response.setPesan("Nomor Pengaduan Salah!");
        }
        return response;
    }
    @PutMapping("/tindak-lanjut3/{noPengaduan}")
    public DefaultResponse<FormPengaduanDto> update3 (@PathVariable Long noPengaduan){
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan entity = new FormPengaduan();
        FormPengaduanDto dto = convertToDto(entity);
        Optional<FormPengaduan> optional = formPengaduanrepo.findById(noPengaduan);
        if(optional.isPresent()){
            pengaduanService.updateStatusComplaint2(noPengaduan);
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(dto);
        } else{
            response.setPesan("Nomor Pengaduan Salah!");
        }
        return response;
    }

    private FormPengaduan convertToEntity(FormPengaduanDto dto){
        FormPengaduan pengaduan = new FormPengaduan();
        pengaduan.setNoPengaduan(dto.getNoPengaduan());
        pengaduan.setDeskripsi(dto.getDeskripsi());
        pengaduan.setAlamat(dto.getAlamat());
        pengaduan.setFoto(dto.getFoto());
        pengaduan.setStatus(dto.getStatus());

        return pengaduan;
    }
    private FormPengaduanDto convertToDto(FormPengaduan entity){
        FormPengaduanDto dto = new FormPengaduanDto();
        dto.setNoPengaduan(entity.getNoPengaduan());
        dto.setAlamat(entity.getAlamat());
        dto.setDeskripsi(entity.getDeskripsi());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
