package com.prodemy.pembayaran.listrik.model.dto;

import java.util.Date;

public class TagihanDto {
    private Long noTagihan;
//    private Long noTransaksi;
    private String idUser;
    private String idPenggunaListrik;
//    private Date tanggal;
    private String bulan;
    private Long biaya;
    private Long kwh;
    private String status;
    private String metodePembayaran;

    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

//    public Long getNoTransaksi() {
//        return noTransaksi;
//    }
//
//    public void setNoTransaksi(Long noTransaksi) {
//        this.noTransaksi = noTransaksi;
//    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(String idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

//    public Date getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(Date tanggal) {
//        this.tanggal = tanggal;
//    }


    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }

    public Long getKwh() {
        return kwh;
    }

    public void setKwh(Long kwh) {
        this.kwh = kwh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
}
