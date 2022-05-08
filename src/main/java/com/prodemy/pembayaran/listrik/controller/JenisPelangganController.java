package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.JenisPelangganRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.JenisPelangganDto;
import com.prodemy.pembayaran.listrik.model.entity.JenisPelanggan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jenis")
public class JenisPelangganController {
    private final JenisPelangganRepo jenisPelangganRepo;

    public JenisPelangganController (JenisPelangganRepo jenisPelangganRepo) {
        this.jenisPelangganRepo = jenisPelangganRepo;
    }

    @PostMapping("/tarif")
    public JenisPelangganDto[] addtarif (@RequestBody JenisPelangganDto[] listtarif){
        for(JenisPelangganDto t : listtarif) {
            jenisPelangganRepo.save(convertToEntity(t));
        }
        return listtarif;
    }

    @GetMapping("/listjenis")
    public List<JenisPelangganDto> getListAll(){
        List<JenisPelangganDto> list = new ArrayList<>();
        for(JenisPelanggan m : jenisPelangganRepo.findAll()) {
            list.add(convertToDto(m));
        }
        return list;
    }
    @PutMapping("/updatetarif")
    public DefaultResponse<JenisPelangganDto> update(@RequestBody JenisPelangganDto jenisPelangganDto){
        DefaultResponse<JenisPelangganDto>response=new DefaultResponse<>();
        Optional<JenisPelanggan> optional = jenisPelangganRepo.findById(jenisPelangganDto.getIdJenis());
        if(optional.isPresent()){
            response.setPesan("Update jenis pengguna listrik berhasil");
            response.setData(jenisPelangganDto);
            jenisPelangganRepo.save(convertToEntity(jenisPelangganDto));
        }else{
            response.setPesan("Gagal update! Jenis pengguna listrik belum terdaftar");
        }
        return response;
    }

    private JenisPelanggan convertToEntity(JenisPelangganDto dto) {
        JenisPelanggan jns = new JenisPelanggan();
        jns.setJenis(dto.getJenis());
        jns.setDaya(dto.getDaya());
        jns.setTarif(dto.getTarif());
        return jns;
    }

    private JenisPelangganDto convertToDto(JenisPelanggan jns) {
        JenisPelangganDto dto = new JenisPelangganDto();
        dto.setIdJenis(jns.getIdJenis());
        dto.setJenis(jns.getJenis());
        dto.setDaya(jns.getDaya());
        dto.setTarif(jns.getTarif());
        return dto;
    }

}
