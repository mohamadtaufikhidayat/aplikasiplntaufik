package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.LoginRepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.UserDto;
import com.prodemy.pembayaran.listrik.model.entity.Login;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/home")
public class LoginController {

    @Autowired
    Userrepo repo;

    @Autowired
    LoginRepo logrep;

    @PostMapping("/login")
    public DefaultResponse login(@RequestBody UserDto dto) {
        DefaultResponse<UserDto> respon = new DefaultResponse<>();
        Optional<User> option = repo.findByEmail(dto.getEmail());
        if (option.isEmpty()) {
            respon.setPesan("Email Tidak Ada");
        } else {
            Optional<User> password = repo.findByPassword(dto.getEmail());
            if (String.valueOf(password).equals(String.format("Optional[%s]", dto.getPassword()))) {
                respon.setData(dto);
                Optional<User> role = repo.findByPegawai(dto.getEmail());
                if (role.isPresent()) {
                    respon.setPesan("Login Berhasil,ADMIN");
                    logrep.save(convertToEntity(dto));
                } else {
                    respon.setPesan("Login Berhasil,USER");
                    logrep.save(convertToEntity(dto));
                }
            } else {
                respon.setPesan("Password Salah");

            }
        }
        return respon;
    }


    private Login convertToEntity(UserDto dto) {
        Login log = new Login();
        log.setId(dto.getId());
//        log.setEmail(dto.getEmail());
        log.setPassword(dto.getPassword());
        return log;
    }
}
