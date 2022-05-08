package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.CatatMeterRepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.CatatMeterDto;
import com.prodemy.pembayaran.listrik.model.entity.CatatMeter;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catat")
public class CatatMeterController {

    private final CatatMeterRepo catatMeterRepo;

    private final DataPelRepo dataPelRepo;

//    private final Tagihanrepo tagihanrepo;

    public CatatMeterController(CatatMeterRepo catatMeterRepo, DataPelRepo dataPelRepo){
        this.catatMeterRepo = catatMeterRepo;
        this.dataPelRepo = dataPelRepo;
//        this.tagihanrepo = tagihanrepo;
    }
    @PostMapping("/kwh")
    public CatatMeterDto catatKwh (@RequestBody CatatMeterDto ct){
        CatatMeter catat = convertToEntity(ct);
        catatMeterRepo.save(catat);
        return convertToDto(catat);
    }
    private CatatMeter convertToEntity(CatatMeterDto ct) {
        CatatMeter cttkwh = new CatatMeter();
        if(dataPelRepo.findById(ct.getIdPenggunaListrik()).isPresent()){
            PenggunaListrik penggunaListrik = dataPelRepo.findById(ct.getIdPenggunaListrik()).get();
            cttkwh.setIdPenggunaListrik(penggunaListrik);
        }
        cttkwh.setBulanini(ct.getBulanini());
        cttkwh.setCttkwh(ct.getCttkwh());

        return cttkwh;
    }
    private CatatMeterDto convertToDto(CatatMeter catat) {
        CatatMeterDto dto = new CatatMeterDto();
        dto.setNoUrut(catat.getNoUrut());
        dto.setIdPenggunaListrik(catat.getIdPenggunaListrik().getIdPengguna());
        dto.setBulanini(catat.getBulanini());
        dto.setCttkwh(catat.getCttkwh());

        return dto;
    }
}
