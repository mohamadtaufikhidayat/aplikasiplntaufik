package com.prodemy.pembayaran.listrik.model.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tbl_user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long noInduk;
    @Column
    private String password;
    @Column
    private String email;

    @Column(name = "no_pegawai")
    private Long data;
    @OneToOne
    @JoinColumn(name = "no_peg")
    private Admin pegawai;

    @ManyToMany
    @JoinTable(
            name = "tb_user_peng",
            joinColumns = @JoinColumn(name="id_Pelanggan"),
            inverseJoinColumns = @JoinColumn(name = "id_idPengguna")
    )
    Set <PenggunaListrik> daftarPengguna = new HashSet<>();

    public Long getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(Long userid) {
        this.noInduk = userid;
    }

    public void setDaftarPengguna(Set<PenggunaListrik> daftarPengguna) {
        this.daftarPengguna = daftarPengguna;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin getPegawai() {
        return pegawai;
    }

    public void setPegawai(Admin pegawai) {
        this.pegawai = pegawai;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Set<PenggunaListrik> getDaftarPengguna() {
        return daftarPengguna;
    }
}

