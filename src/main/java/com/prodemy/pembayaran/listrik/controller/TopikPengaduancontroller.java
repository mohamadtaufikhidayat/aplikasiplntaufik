package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.TopikPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.TopikPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/topik-pengaduan")
public class TopikPengaduancontroller {

    private final TopikPengaduanrepo topikPengaduanrepo;

    public TopikPengaduancontroller(TopikPengaduanrepo topikPengaduanrepo) {
        this.topikPengaduanrepo = topikPengaduanrepo;
    }

    @GetMapping("/list-topik-berdasarkan-kelompok/{kelompokTopik}")
    public List<TopikPengaduanDto> getListTopikBerdasarkanKelompok(@PathVariable String kelompokTopik){
        List<TopikPengaduanDto> list = new ArrayList<>();
        for(TopikPengaduan x: topikPengaduanrepo.findAllByKelompokTopik(kelompokTopik)){
            list.add(convertEntityToDto2(x));
        }
        return list;
    }

//    @GetMapping("/list-kelompok-topik")
//    public DefaultResponse<TopikPengaduanDto> getListKelompokTopik(){
//        DefaultResponse<TopikPengaduanDto> response = new DefaultResponse<>();
//        List list = topikPengaduanrepo.getDistinctByKelompokTopik();
//        response.setPesan("Silahkan Pilih Kelompok Topik");
//        response.setData(convertEntityToDto1(list));
//        return response;
//    }
    @GetMapping("/list-kelompok-topik2")
    public List getListKelompokTopik2(){
        List list1 = topikPengaduanrepo.getDistinctByKelompokTopik();
        return list1;
    }
    @GetMapping("/list-all-topik")
    public List<TopikPengaduanDto> getListTopik(){
        List<TopikPengaduanDto> list = new ArrayList<>();
        for(TopikPengaduan x: topikPengaduanrepo.findAll()){
            list.add(convertEntityToDto2(x));
        }
        return list;
    }

     public TopikPengaduanDto convertEntityToDto1 (TopikPengaduan entity){
        TopikPengaduanDto dto = new TopikPengaduanDto();
        dto.setKelompokTopik(entity.getKelompokTopik());
        return dto;
    }
    public TopikPengaduanDto convertEntityToDto2 (TopikPengaduan entity){
        TopikPengaduanDto dto = new TopikPengaduanDto();
        dto.setNamaTopik(entity.getNamaTopik());
        return dto;
    }
    public TopikPengaduan convertDtoToEntity (TopikPengaduanDto dto) {
        TopikPengaduan entity = new TopikPengaduan();
        entity.setKelompokTopik(dto.getKelompokTopik());
        entity.setNamaTopik(dto.getNamaTopik());
        return entity;
    }
}