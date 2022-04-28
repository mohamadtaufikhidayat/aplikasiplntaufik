package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_plistrik")
public class PenggunaListrik {
    @Id
    @Column
    private String idPengguna;
    @Column
    private String namaPengguna;
    @Column
    private String alamat;
    @Column
    private String golonganDaya;
    @Column
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
