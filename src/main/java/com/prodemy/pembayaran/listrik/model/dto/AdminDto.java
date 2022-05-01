package com.prodemy.pembayaran.listrik.model.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class AdminDto {


    private Long id;

    private String nama;

    private Long no_aplikasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getNo_aplikasi() {
        return no_aplikasi;
    }

    public void setNo_aplikasi(Long no_aplikasi) {
        this.no_aplikasi = no_aplikasi;
    }
}
