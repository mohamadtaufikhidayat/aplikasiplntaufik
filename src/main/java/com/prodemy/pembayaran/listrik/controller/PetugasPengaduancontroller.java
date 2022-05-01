package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.FormPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/petugas-pengaduan")
public class PetugasPengaduancontroller {
    private final FormPengaduanrepo formPengaduanrepo;
    private final DataPelRepo penggunaListrikrepo;

    public PetugasPengaduancontroller(FormPengaduanrepo formPengaduanrepo, DataPelRepo penggunaListrikrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
        this.penggunaListrikrepo = penggunaListrikrepo;
    }
    @GetMapping("/tindak-lanjut/{noPengaduan}")
    public FormPengaduanDto getNotifikasi(@PathVariable Long noPengaduan){
        FormPengaduan pengaduan = formPengaduanrepo.findByNoPengaduan(noPengaduan);
        FormPengaduanDto dto = convertToDto(pengaduan);
        return dto;
    }

//    @GetMapping("/list-topik-berdasarkan-kelompok/{kelompokTopik}")
//    public List<TopikPengaduanDto> getListTopikBerdasarkanKelompok(@PathVariable String kelompokTopik){
//        List<TopikPengaduanDto> list = new ArrayList<>();
//        for(TopikPengaduan x: topikPengaduanrepo.findAllByKelompokTopik(kelompokTopik)){
//            list.add(convertEntityToDto2(x));
//        }
//        return list;
//    }

    @GetMapping("/tindak-lanjut2/{noPengaduan}")
    public DefaultResponse<FormPengaduanDto> insertForm (@PathVariable Long noPengaduan){
        DefaultResponse<FormPengaduanDto> response = new DefaultResponse<>();
        FormPengaduan pengaduan = formPengaduanrepo.findByNoPengaduan(noPengaduan);
        formPengaduanrepo.save(pengaduan);
        response.setPesan("Pengaduan sedang ditindaklanjuti");
//        response.setData(pengaduan);
        return response;
    }
    private FormPengaduanDto convertToDto(FormPengaduan entity){
        FormPengaduanDto dto = new FormPengaduanDto();
        dto.setNoPengaduan(entity.getNoPengaduan());
        dto.setDeskripsi(entity.getDeskripsi());
        dto.setAlamat(entity.getAlamat());
        dto.setFoto(entity.getFoto());

        return dto;
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
}
