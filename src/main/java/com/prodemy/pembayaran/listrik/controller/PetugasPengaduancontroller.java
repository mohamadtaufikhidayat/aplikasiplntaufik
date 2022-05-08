package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.*;
import com.prodemy.pembayaran.listrik.Service.PengaduanService;
import com.prodemy.pembayaran.listrik.model.dto.AssignmentDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.dto.PetugasPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/petugas-pengaduan")
public class PetugasPengaduancontroller {
    private final TopikPengaduanrepo topikPengaduanrepo;
    private final PetugasPengaduanrepo petugasPengaduanrepo;
    private final Assignmentrepo assignmentrepo;
    private final PengaduanService pengaduanService;
    private final FormPengaduanrepo formPengaduanrepo;
    private final DataPelRepo penggunaListrikrepo;

    public PetugasPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo penggunaListrikrepo, PengaduanService pengaduanService, Assignmentrepo assignmentrepo, PetugasPengaduanrepo petugasPengaduanrepo, TopikPengaduanrepo topikPengaduanrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
        this.pengaduanService = pengaduanService;
        this.assignmentrepo = assignmentrepo;
        this.petugasPengaduanrepo = petugasPengaduanrepo;
        this.topikPengaduanrepo = topikPengaduanrepo;
    }
    @PutMapping("/tindak-lanjut/{noPengaduan}")
    public int update (@PathVariable Long noPengaduan){
        return pengaduanService.updateStatusComplaint(noPengaduan);
    }

    @PostMapping ("/tindak-lanjut2")
    public DefaultResponse<PetugasPengaduanDto> update2 (@RequestBody FormPengaduanDto dto){
        List<FormPengaduan> formPengaduanList = new ArrayList<>();
        PetugasPengaduanDto dto1 = convertToDto (dto);
        DefaultResponse<PetugasPengaduanDto> response = new DefaultResponse<>();
        for(FormPengaduan m: formPengaduanrepo.findAllByNoPengaduan(dto.getNoPengaduan())){
            formPengaduanList.add(m);
        }
        if(formPengaduanList.isEmpty()){
            response.setPesan("Nomor Pengaduan Salah!");
        } else{
            pengaduanService.updateStatusComplaint(dto.getNoPengaduan());
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(dto1);
        }
        return response;
    }
    @PostMapping ("/tindak-lanjut3")
    public DefaultResponse<PetugasPengaduanDto> update3 (@RequestBody FormPengaduanDto dto){
        List<FormPengaduan> formPengaduanList = new ArrayList<>();
        PetugasPengaduanDto dto1 = convertToDto2 (dto);
        DefaultResponse<PetugasPengaduanDto> response = new DefaultResponse<>();
        for(FormPengaduan m: formPengaduanrepo.findAllByNoPengaduan(dto.getNoPengaduan())){
            formPengaduanList.add(m);
        }
        if(formPengaduanList.isEmpty()){
            response.setPesan("Nomor Pengaduan Salah!");
        } else{
            pengaduanService.updateStatusComplaint2(dto.getNoPengaduan());
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(dto1);
        }
        return response;
    }
    private PetugasPengaduanDto convertToDto(FormPengaduanDto dto) {
        PetugasPengaduanDto dto1 = new PetugasPengaduanDto();
        dto1.setNoPengaduan(dto.getNoPengaduan());
        dto1.setStatus("Sedang ditindak-lanjuti");
        return dto1;
    }
    private PetugasPengaduanDto convertToDto2(FormPengaduanDto dto) {
        PetugasPengaduanDto dto1 = new PetugasPengaduanDto();
        dto1.setNoPengaduan(dto.getNoPengaduan());
        dto1.setStatus("Pengaduan selesai, masalah telah diatasi");
        return dto1;
    }


}
