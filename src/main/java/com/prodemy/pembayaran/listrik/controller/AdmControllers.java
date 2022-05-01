package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.AdminRepo;
import com.prodemy.pembayaran.listrik.model.dto.AdminDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdmControllers {

    @Autowired
    AdminRepo repo;

    @PostMapping("/admin")
    public DefaultResponse register(@RequestBody AdminDto dto){
        DefaultResponse<AdminDto> data = new DefaultResponse<>();
        Optional<Admin> option = repo.findById(dto.getId());
        if(option.isPresent()){
            Admin adm = repo.findByNo_aplikasi(dto.getId()).get();
            data.setPesan("Register Gagal Anda sudah terdaftar ");

        }else{
            registrasi(dto);
            Admin adm = repo.findByNo_aplikasi(dto.getId()).get();
            data.setData(convertEntitytoDTO(adm));
            data.setPesan("Regitrasi Berhasil!!!");
        }
        return data;
    }


    public AdminDto registrasi(AdminDto dto) {
        Admin data = convertDTOtoEntity(dto);
        repo.save(data);
        return dto;

    }
    public Admin convertDTOtoEntity(AdminDto dto) {
        Admin data = new Admin();
        data.setNama(dto.getNama());
        data.setId(dto.getId());
        data.setNo_aplikasi(dto.getNo_aplikasi());
        return data;
    }
    public AdminDto convertEntitytoDTO(Admin data) {
        AdminDto dto = new AdminDto();
        dto.setNama(data.getNama());
        dto.setId(data.getId());
        dto.setNo_aplikasi(data.getNo_aplikasi());
        return dto;
    }
}
