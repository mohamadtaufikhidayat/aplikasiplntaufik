package com.prodemy.pembayaran.listrik.model.dto;

public class AccountDto {
    private Long id;

    private Long notel;
    private Long nomor;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
