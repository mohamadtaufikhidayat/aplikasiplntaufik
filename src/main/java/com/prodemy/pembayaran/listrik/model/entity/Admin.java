package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_admin")
public class Admin {
    @Id
    private Long id;

    private String nama;


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
}
