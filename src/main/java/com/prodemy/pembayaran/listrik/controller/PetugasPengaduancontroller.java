package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.Assignmentrepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.PetugasPengaduanrepo;
import com.prodemy.pembayaran.listrik.Service.PengaduanService;
import com.prodemy.pembayaran.listrik.model.dto.AssignmentDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/petugas-pengaduan")
public class PetugasPengaduancontroller {
    private final PetugasPengaduanrepo petugasPengaduanrepo;
    private final Assignmentrepo assignmentrepo;
    private final PengaduanService pengaduanService;
    private final FormPengaduanrepo formPengaduanrepo;
    private final DataPelRepo penggunaListrikrepo;

    public PetugasPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo penggunaListrikrepo, PengaduanService pengaduanService, Assignmentrepo assignmentrepo, PetugasPengaduanrepo petugasPengaduanrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
        this.pengaduanService = pengaduanService;
        this.assignmentrepo = assignmentrepo;
        this.petugasPengaduanrepo = petugasPengaduanrepo;
    }
    @PutMapping("/tindak-lanjut/{noPengaduan}")
    public int update (@PathVariable Long noPengaduan){
        return pengaduanService.updateStatusComplaint(noPengaduan);
    }

    @PostMapping ("/tindak-lanjut2")
    public DefaultResponse<FormPengaduan> update2 (@RequestBody FormPengaduanDto dto){
        List<FormPengaduan> formPengaduanList = new ArrayList<>();
        FormPengaduan entity = convertDtoToEntity(dto);
        DefaultResponse<FormPengaduan> response = new DefaultResponse<>();
        for(FormPengaduan m: formPengaduanrepo.findAllByNoPengaduan(dto.getNoPengaduan())){
            formPengaduanList.add(m);
        }
        if(formPengaduanList.isEmpty()){
            response.setPesan("Nomor Pengaduan Salah!");
        } else{
            pengaduanService.updateStatusComplaint(dto.getNoPengaduan());
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(entity);
        }
        return response;
    }

    private FormPengaduan convertDtoToEntity(FormPengaduanDto dto) {
        FormPengaduan entity = new FormPengaduan();
        entity.setNoPengaduan(dto.getNoPengaduan());
        entity.setAlamat(dto.getAlamat());
        entity.setDeskripsi(dto.getDeskripsi());
        entity.setStatus("Sedang ditindak-lanjuti");
        return entity;
    }

    @PostMapping ("/tindak-lanjut3")
    public DefaultResponse<FormPengaduan> update3 (@RequestBody FormPengaduanDto dto){
        List<FormPengaduan> formPengaduanList = new ArrayList<>();
        FormPengaduan entity = convertDtoToEntity2(dto);
        DefaultResponse<FormPengaduan> response = new DefaultResponse<>();
        for(FormPengaduan m: formPengaduanrepo.findAllByNoPengaduan(dto.getNoPengaduan())){
            formPengaduanList.add(m);
        }
        if(formPengaduanList.isEmpty()){
            response.setPesan("Nomor Pengaduan Salah!");
        } else{
            pengaduanService.updateStatusComplaint2(dto.getNoPengaduan());
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(entity);
        }
        return response;
    }

    private FormPengaduan convertDtoToEntity2(FormPengaduanDto dto) {
        FormPengaduan entity = new FormPengaduan();
        entity.setNoPengaduan(dto.getNoPengaduan());
        entity.setAlamat(dto.getAlamat());
        entity.setDeskripsi(dto.getDeskripsi());
        entity.setStatus("Pengaduan selesai, masalah telah diatasi");
        return entity;
    }

}
