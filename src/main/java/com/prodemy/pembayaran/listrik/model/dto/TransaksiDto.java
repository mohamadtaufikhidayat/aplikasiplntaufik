package com.prodemy.pembayaran.listrik.model.dto;

import java.util.Date;

public class TransaksiDto {
    private Long noTransaksi;
    private Long noTagihan;
    private String idPenggunaListrik;
    private String idUser;
    private Date tanggal;
    private Long biaya;

    public Long getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(Long noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

    public String getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(String idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
