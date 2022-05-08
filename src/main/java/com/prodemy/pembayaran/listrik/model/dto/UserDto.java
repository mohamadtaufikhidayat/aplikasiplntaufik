package com.prodemy.pembayaran.listrik.model.dto;



public class UserDto {
    private Long id;
    private String password;
    private String email;
    private Long  no_pegawai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNo_pegawai() {
        return no_pegawai;
    }

    public void setNo_pegawai(Long no_pegawai) {
        this.no_pegawai = no_pegawai;
    }
}
