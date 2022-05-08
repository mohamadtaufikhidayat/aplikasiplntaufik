package com.prodemy.pembayaran.listrik.model.dto;


public class PasangBaruDto {
    private Long noUrut;
    private String namaCalonPengguna;
    private String alamat;
    private String jenisPengguna;
    private Long daya;
    private String kontak;
    private String status;

    public Long getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Long noUrut) {
        this.noUrut = noUrut;
    }

    public String getNamaCalonPengguna() {
        return namaCalonPengguna;
    }

    public void setNamaCalonPengguna(String namaCalonPengguna) {
        this.namaCalonPengguna = namaCalonPengguna;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisPengguna() {
        return jenisPengguna;
    }

    public void setJenisPengguna(String jenisPengguna) {
        this.jenisPengguna = jenisPengguna;
    }

    public Long getDaya() {
        return daya;
    }

    public void setDaya(Long daya) {
        this.daya = daya;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
