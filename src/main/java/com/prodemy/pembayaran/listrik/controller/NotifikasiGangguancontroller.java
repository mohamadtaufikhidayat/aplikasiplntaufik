package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.Gangguanrepo;
import com.prodemy.pembayaran.listrik.Service.GangguanService;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.dto.GangguanDto;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.Gangguan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.MessageInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifikasi-gangguan")
public class NotifikasiGangguancontroller {
    private final GangguanService gangguanService;
    private final Gangguanrepo gangguanrepo;

    private final DataPelRepo dataPelRepo;

    public NotifikasiGangguancontroller(DataPelRepo dataPelRepo, Gangguanrepo gangguanrepo, GangguanService gangguanService) {
        this.dataPelRepo = dataPelRepo;
        this.gangguanrepo = gangguanrepo;
        this.gangguanService = gangguanService;
    }

    @PostMapping("/insert-gangguan")
    public DefaultResponse<Gangguan>  insertGangguan2 (@RequestBody GangguanDto dto){
        List<PenggunaListrik> listPengguna = new ArrayList<>();
        Gangguan entity =convertToEntity(dto);
        DefaultResponse<Gangguan> defaultResponse = new DefaultResponse<>();
        for(PenggunaListrik x: dataPelRepo.findByAlamat(dto.getLokasi())){
            listPengguna.add(x);
        }
        if(listPengguna.isEmpty()){
            defaultResponse.setPesan("Alamat salah! Silahkan masukkan Nama Kecamatan, Kota, dan Provinsi");
        } else{
            gangguanrepo.save(entity);
            defaultResponse.setPesan("Gangguan berhasil masuk kedalam database");
            defaultResponse.setData(entity);
        }
        return defaultResponse;
    }
    @GetMapping("/informasi-gangguan/{lokasi}")
    public DefaultResponse<List<Gangguan>> gangguan (@PathVariable String lokasi){
        DefaultResponse<List<Gangguan>> response = new DefaultResponse<>();
        List<Gangguan> entity = new ArrayList<>();
        Optional<Gangguan> optional = gangguanrepo.findByStatusAndLokasiEqualsIgnoreCase(lokasi);
        for(Gangguan x: gangguanrepo.findByLokasiEqualsIgnoreCaseAndStatusIsTrue(lokasi)){
            entity.add(x);
        }
        if (optional.isPresent()) {
            response.setPesan("Sedang ada gangguan pada lokasi : "+ lokasi);
            response.setData(entity);
        } else {
          response.setPesan ("Tidak ada gangguan pada lokasi : "+ lokasi);
        }
        return response;
    }

    @PostMapping ("/tindak-lanjut")
    public DefaultResponse<Gangguan> update2 (@RequestBody GangguanDto dto){
        List<Gangguan> gangguanList = new ArrayList<>();
        Gangguan entity = convertToEntity2(dto);
        DefaultResponse<Gangguan> response = new DefaultResponse<>();
        for(Gangguan m: gangguanrepo.findByNoGangguan(dto.getNoGangguan())){
            gangguanList.add(m);
        }
        if(gangguanList.isEmpty()){
            response.setPesan("Nomor Pengaduan Salah!");
        } else{
            gangguanService.updateStatusGangguan(dto.getNoGangguan());
            response.setPesan("Status Berhasil Diperbarui");
            response.setData(entity);
        }
        return response;
    }
    private Gangguan convertToEntity(GangguanDto dto) {
        Gangguan entity = new Gangguan();
        entity.setNoGangguan(dto.getNoGangguan());
        entity.setLokasi(dto.getLokasi());
        entity.setStatus(true);
        entity.setDeskripsi(dto.getDeskripsi());
        return entity;
    }

    private Gangguan convertToEntity2(GangguanDto dto) {
        Gangguan entity = new Gangguan();
        entity.setNoGangguan(dto.getNoGangguan());
        entity.setLokasi(dto.getLokasi());
        entity.setStatus(false);
        entity.setDeskripsi(dto.getDeskripsi());
        return entity;
    }
}
