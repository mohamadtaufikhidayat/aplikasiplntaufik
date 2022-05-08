package com.prodemy.pembayaran.listrik.model.dto;

public class TagihanDto {
    private Long noTagihan;
//<<<<<<< HEAD
//    private Long noUrut;
//    private Long idPenggunaListrik;
//=======
//    private Long noTransaksi;
    private String idUser;
    private Long idPenggunaListrik;
//    private Date tanggal;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    private String bulan;
    private Long biaya;
    private Long kwh;
    private String metodePembayaran;
    private String status;
    private String metodePembayaran;


    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

//<<<<<<< HEAD
//    public Long getNoUrut() {
//        return noUrut;
//    }
//
//    public void setNoUrut(Long noUrut) {
//        this.noUrut = noUrut;
//=======
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    }

    public Long getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(Long idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

//<<<<<<< HEAD
//=======
//    public Date getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(Date tanggal) {
//        this.tanggal = tanggal;
//    }


//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//<<<<<<< HEAD
//
//=======
    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
