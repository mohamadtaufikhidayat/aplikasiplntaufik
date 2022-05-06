package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.Gangguanrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.GangguanDto;
import com.prodemy.pembayaran.listrik.model.dto.PenggunaListrikDto;
import com.prodemy.pembayaran.listrik.model.entity.Gangguan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notifikasi-gangguan")
public class NotifikasiGangguancontroller {
    private final Gangguanrepo gangguanrepo;

    private final DataPelRepo dataPelRepo;

    public NotifikasiGangguancontroller(DataPelRepo dataPelRepo, Gangguanrepo gangguanrepo) {
        this.dataPelRepo = dataPelRepo;
        this.gangguanrepo = gangguanrepo;
    }

//    @GetMapping("/notifikasi/{alamat}")
//    public DefaultResponse<GangguanDto> getNotification(@PathVariable String alamat) {
//        DefaultResponse<GangguanDto> response = new DefaultResponse<>();
//        Gangguan entity = new Gangguan();
//        GangguanDto dto = convertEntityToDto(entity);
//        Optional<PenggunaListrik> optional = dataPelRepo.findAllByAlamat(alamat);
//        if (optional.isPresent()){
//            response.setPesan("Ada gangguan listrik di daerah anda! Harap sabar menunngu, perbaikan akan segera dilakukan");
//            response.setData(dto);
//        } else{
//            response.setPesan("Alamat salah! Silahkan masukkan Nama Kecamatan, Kota, dan Provinsi");
//        }
//        return response;
//    }
    private GangguanDto convertEntityToDto(Gangguan entity){
        GangguanDto dto = new GangguanDto();
        dto.setLokasi(entity.getLokasi());
        dto.setDeskripsi(entity.getDeskripsi());
        dto.setStatus(entity.getStatus());
        dto.setNoGangguan(entity.getNoGangguan());
        return dto;

    }

    private PenggunaListrikDto convertToDto(PenggunaListrik entity) {
        PenggunaListrikDto dto = new PenggunaListrikDto();
        dto.setIdPengguna(entity.getIdPengguna());
        dto.setNamaPengguna(entity.getNamaPengguna());
        dto.setAlamat(entity.getAlamat());
        return dto;
    }

    @GetMapping("/gangguan2/{alamat}")
    public DefaultResponse<List<PenggunaListrik>> getListPengguna(@PathVariable String alamat){
        List<PenggunaListrik> list = new ArrayList<>();
        DefaultResponse<List<PenggunaListrik>> defaultResponse = new DefaultResponse<>();
        for(PenggunaListrik x: dataPelRepo.findByAlamat(alamat)){
            list.add(x);
        }
        if(list.isEmpty()){
            defaultResponse.setPesan("Alamat salah! Silahkan masukkan Nama Kecamatan, Kota, dan Provinsi");
        } else{
            defaultResponse.setPesan("Ada gangguan listrik di daerah anda! Harap sabar menunngu, perbaikan akan segera dilakukan");
            defaultResponse.setData(list);
        }

        return defaultResponse;
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

    private Gangguan convertToEntity(GangguanDto dto) {
        Gangguan entity = new Gangguan();
        entity.setNoGangguan(dto.getNoGangguan());
        entity.setLokasi(dto.getLokasi());
        entity.setStatus("gangguan sedang berlansung");
        entity.setDeskripsi(dto.getDeskripsi());
        return entity;
    }
}
