package com.prodemy.pembayaran.listrik.model.dto;


public class UbahDayaDto {
    private Long noUrut;
    private Long idPenggunaListrik;
    private String namaPengguna;
    private String alamat;
    private String jenisPengguna;
    private String daya;
    private String jenisPenggunaubah;
    private Long dayaBaru;
    private String kontak;
    private String status;

    public Long getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Long noUrut) {
        this.noUrut = noUrut;
    }

    public Long getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(Long idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
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

    public String getDaya() {
        return daya;
    }

    public void setDaya(String daya) {
        this.daya = daya;
    }

    public String getJenisPenggunaubah() {
        return jenisPenggunaubah;
    }

    public void setJenisPenggunaubah(String jenisPenggunaubah) {
        this.jenisPenggunaubah = jenisPenggunaubah;
    }

    public Long getDayaBaru() {
        return dayaBaru;
    }

    public void setDayaBaru(Long dayaBaru) {
        this.dayaBaru = dayaBaru;
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
