package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class Admin {
    @Id
    private Long id;

    private String nama;

    @Column(unique = true,nullable = false)//Masih Bingung gimana bisa auto generated value
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
