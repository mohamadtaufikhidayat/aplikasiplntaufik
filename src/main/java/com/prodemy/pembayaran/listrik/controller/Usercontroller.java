package com.prodemy.pembayaran.listrik.controller;


import com.prodemy.pembayaran.listrik.Repository.AdminRepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.Service.UserService;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.UserDto;
import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/home")
public class Usercontroller {

   @Autowired
   UserService service;

   @Autowired
   Userrepo repo;
//<<<<<<< HEAD
//=======

   @Autowired
   AdminRepo adm;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    //http://localhost:8383/home/register
    @PostMapping("/register")
    public DefaultResponse regis(@RequestBody UserDto dto) {
        DefaultResponse<UserDto> respon = new DefaultResponse<>();
        Optional<User> option = repo.findByEmail(dto.getEmail());
        if (option.isEmpty()) {
//<<<<<<< HEAD
//            respon.setPesan("Register Berhasil");
//            respon.setData(dto);
//            service.register(dto);
//        } else {
//            respon.setPesan("Register Gagal Email Sudah Terdafatar");
//        }
//        return respon;
//    }
//
//
//
//    @GetMapping
//    public List<UserDto> get() {
//        List<User> kotaList = repo.findAll();
//        List<UserDto> kotaDtoList = kotaList.stream().map(this::convertToDto)
//                .collect(Collectors.toList());
//        return kotaDtoList;
//    }
//    private UserDto convertToDto(User kota){
//        UserDto kotaDto = new UserDto();
//        kotaDto.setId(kota.getNoInduk());
//        kotaDto.setEmail(kota.getEmail());
//        kotaDto.setPassword(kota.getPassword());
//        return kotaDto;
//    }
//
//=======
            Optional<Admin> role = adm.findByNo_aplikasi(dto.getNo_pegawai());
            if (role.isPresent()) {
                respon.setPesan("Register Berhasil");
                respon.setData(dto);
                service.register(dto);
                }else {
                respon.setPesan("No Aplikasi Tidak Ditemukan");}
            }else{
            respon.setPesan("Register Gagal Email Sudah Terdaftar");}
            return respon;
        }
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
