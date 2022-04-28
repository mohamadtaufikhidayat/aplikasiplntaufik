package com.prodemy.pembayaran.listrik.controller;


import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.UserDto;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/home")
public class Usercontroller {
    @Autowired
    Userrepo repo;


    //http://localhost:8383/home/register
    @PostMapping("/register")
    public DefaultResponse regis(@RequestBody UserDto dto) {
        User data = new User();
        DefaultResponse<UserDto> respon = new DefaultResponse<>();
        Optional<User> option = repo.findByEmail(dto.getEmail());
        if (option.isEmpty()) {
            respon.setPesan("Register Berhasil");
            respon.setData(dto);
            register(dto);
        } else {
            respon.setPesan("Register Gagal Email Sudah Terdafatar");
        }
        return respon;
    }
    public UserDto register (UserDto dto) {
        User data = convertDTOtoEntity(dto);
        repo.save(data);
        return dto;
    }

    public User convertDTOtoEntity(UserDto dto) {
        User data =new User();
        data.setIdUser(dto.getIdUser());
        data.setEmail(dto.getEmail());
        data.setPassword(dto.getPassword());
        return data;
    }
}
