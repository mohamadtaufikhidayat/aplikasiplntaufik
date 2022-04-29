package com.prodemy.pembayaran.listrik.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

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
    private String golonganDaya;
    @Column
    private Long daya;

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

    public Set<User> getUser() {
        return user;
    }
}
