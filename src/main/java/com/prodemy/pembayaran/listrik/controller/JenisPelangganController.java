package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.JenisPelangganRepo;
import com.prodemy.pembayaran.listrik.model.dto.JenisPelangganDto;
import com.prodemy.pembayaran.listrik.model.entity.JenisPelanggan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private JenisPelanggan convertToEntity(JenisPelangganDto dto) {
        JenisPelanggan jns = new JenisPelanggan();
        jns.setJenis(dto.getJenis());
        jns.setDaya(dto.getDaya());
        jns.setTarif(dto.getTarif());
        return jns;
    }

}
