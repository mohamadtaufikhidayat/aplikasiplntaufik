package com.prodemy.pembayaran.listrik.model.entity;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
=======
import javax.persistence.*;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

@Entity
@Table(name="t_plistrik")
public class PenggunaListrik {
    @Id
<<<<<<< HEAD
    @Column(name = "id",unique = true)
    private Long idPengguna;

=======
    @Column(name = "id_peng",unique = true)
    private Long idPengguna;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    @Column
    private String namaPengguna;
    @Column
    private String alamat;
    @Column
<<<<<<< HEAD
=======
    private String provinsi;
    @Column
    private String kota;
    @Column
    private String kecamatan;
    @Column
    private String kelurahan;
    @Column
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    private String jenisPengguna;
    @Column
    private Long daya;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "idJenis")
    private JenisPelanggan idJenis;

    @JsonIgnore
    @ManyToMany(mappedBy = "daftarPengguna")
    private Set<User> user = new HashSet<>();
=======
    @JoinColumn(name="no_penggunaapp", nullable = false)
    private User app;


>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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

<<<<<<< HEAD
    public JenisPelanggan getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(JenisPelanggan idJenis) {
        this.idJenis = idJenis;
    }

    public Set<User> getUser() {
        return user;
=======
    public User getUser() {
        return app;
    }

    public void setUser(User app) {
        this.app = app;
    }

    public String getProvinsi() { return provinsi; }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() { return kota;  }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {return kecamatan; }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {return kelurahan; }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    }
}
