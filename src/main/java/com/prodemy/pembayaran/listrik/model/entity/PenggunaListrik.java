package com.prodemy.pembayaran.listrik.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_plistrik")
public class PenggunaListrik {
    @Id
    @Column(name = "id",unique = true)
    private Long idPengguna;

    @Column
    private String namaPengguna;
    @Column
    private String alamat;
    @Column
    private String jenisPengguna;
    @Column
    private Long daya;

    @ManyToOne
    @JoinColumn(name = "idJenis")
    private JenisPelanggan idJenis;

    @JsonIgnore
    @ManyToMany(mappedBy = "daftarPengguna")
    private Set<User> user = new HashSet<>();
    public Long getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Long idPengguna) {
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

    public JenisPelanggan getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(JenisPelanggan idJenis) {
        this.idJenis = idJenis;
    }

    public Set<User> getUser() {
        return user;
    }
}
