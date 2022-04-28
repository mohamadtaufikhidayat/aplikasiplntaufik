package com.prodemy.pembayaran.listrik.model.dto;

public class PenggunaListrikDto {
    private String idPengguna;
    private String namaPengguna;
    private String alamat;
    private String golonganDaya;
    private Long kwh;
    private Long biaya;

    public String getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(String idPengguna) {
        this.idPengguna = idPengguna;
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

    public String getGolonganDaya() {
        return golonganDaya;
    }

    public void setGolonganDaya(String golonganDaya) {
        this.golonganDaya = golonganDaya;
    }

    public Long getKwh() {
        return kwh;
    }

    public void setKwh(Long kwh) {
        this.kwh = kwh;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
