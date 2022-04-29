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
    @GeneratedValue(generator = "sequencepelangaan" )
    @GenericGenerator(
            name = "sequencepelanggan",strategy = "123",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "1",value = "1"),
                    @org.hibernate.annotations.Parameter(name = "initial_value",value = "12031"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "id_user")
    private Long noInduk;
    @Column
    private String password;
    @Column
    private String email;

    @Column(name = "no_pegawai",unique = true)
    private Long data;

    @OneToOne
    @JoinColumn(name = "no_peg")
    private Admin pegawai;
    @ManyToMany
    @JoinTable(
            name = "enroll",
            joinColumns = @JoinColumn(name="id_pelanggan"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
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

