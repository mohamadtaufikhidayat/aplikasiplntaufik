package com.prodemy.pembayaran.listrik.model.dto;

public class PenggunaListrikDto {
    private String idPengguna;
    private String namaPengguna;
    private String alamat;
    private String golonganDaya;

    private Long daya;

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

    public Long getDaya() {
        return daya;
    }

    public void setDaya(Long daya) {
        this.daya = daya;
    }
}
