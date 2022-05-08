package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "akun")
public class Account {

    @Id
    @Column(name ="no_telp")
    private Long notel;

    @Column(name ="nik",unique = true)
    private Long nomor;

    @Column(name="name")
    private String nama;

    public Long getNotel() {
        return notel;
    }

    public void setNotel(Long notel) {
        this.notel = notel;
    }

    public Long getNomor() {
        return nomor;
    }

    public void setNomor(Long nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
