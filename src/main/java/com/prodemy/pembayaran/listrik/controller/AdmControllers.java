package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.AdminRepo;
//<<<<<<< HEAD
//import com.prodemy.pembayaran.listrik.model.dto.AdminDto;
//import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
//import com.prodemy.pembayaran.listrik.model.entity.Admin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//=======
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.Service.AdminService;
import com.prodemy.pembayaran.listrik.Service.UserService;
import com.prodemy.pembayaran.listrik.model.dto.AdminDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.SearchData;
import com.prodemy.pembayaran.listrik.model.dto.UserDto;
import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
@RestController
@RequestMapping("/admin")
public class AdmControllers {

    @Autowired
    AdminRepo repo;

//<<<<<<< HEAD
//=======
    @Autowired
    Userrepo usrep;
    @Autowired
    AdminService ser;

    @Autowired
    UserService user;

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    @PostMapping("/admin")
    public DefaultResponse register(@RequestBody AdminDto dto){
        DefaultResponse<AdminDto> data = new DefaultResponse<>();
        Optional<Admin> option = repo.findById(dto.getId());
        if(option.isPresent()){
            data.setPesan("Register Gagal Anda sudah terdaftar ");
//<<<<<<< HEAD
//        }else{
//            data.setData(dto);
//            registrasi(dto);
//            data.setPesan("Regitrasi Berhasil!!!");
//        }
//        return data;
//    }
//
//
//    public AdminDto registrasi(AdminDto dto) {
//        Admin data = convertDTOtoEntity(dto);
//        repo.save(data);
//        return convertEntitytoDTO(data);
//
//    }
//    public Admin convertDTOtoEntity(AdminDto dto) {
//        Admin data = new Admin();
//        data.setNama(dto.getNama());
//        data.setId(dto.getId());
//        data.setNo_aplikasi(dto.getNo_aplikasi());
//        return data;
//    }
//    public AdminDto convertEntitytoDTO(Admin data) {
//        AdminDto dto = new AdminDto();
//        dto.setNama(data.getNama());
//        dto.setId(data.getId());
//        dto.setNo_aplikasi(data.getNo_aplikasi());
//        return dto;
//=======

        }else{
            data.setData(dto);
            data.setPesan("Regitrasi Berhasil!!!");
            ser.register(dto);
        }
        return data;
    }
    @GetMapping("/find-all-user")
    public List<UserDto> get() {
        List<User> kotaList = usrep.findAll();
        List<UserDto> kotaDtoList = kotaList.stream().map(this::convertToDtoUser)
                .collect(Collectors.toList());
        return kotaDtoList;
    }
    @PostMapping ("/searchlike")
    public List<User> find(@RequestBody SearchData searchdata){
        List<User> daftar = usrep.findByNameLike("%"+searchdata.getSearchKey()+"%");
        return daftar;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody UserDto dto){
       usrep.deleteById(dto.getId());
    }

    private UserDto convertToDtoUser(User kota){
        UserDto kotaDto = new UserDto();
        kotaDto.setId(kota.getNoInduk());
        kotaDto.setEmail(kota.getEmail());
        kotaDto.setPassword(kota.getPassword());
        kotaDto.setNo_pegawai(kota.getData());
        return kotaDto;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    }
}
