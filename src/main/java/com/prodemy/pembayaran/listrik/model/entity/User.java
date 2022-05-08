package com.prodemy.pembayaran.listrik.model.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//<<<<<<< HEAD
//@Table(name="tbl_user")
//public class User  {
//    @Id
//    @GeneratedValue(generator = "sequencepelangaan" )
//    @GenericGenerator(
//            name = "sequencepelanggan",strategy = "123",
//            parameters = {
//                    @Parameter(name = "1",value = "1"),
//                    @Parameter(name = "initial_value",value = "12031"),
//                    @Parameter(name = "increment_size", value = "1")
//            }
//    )
//    @Column(name = "id_user")
//=======
@Table(name="tb_app")
public class User {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "41021031"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "id_app")
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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
//<<<<<<< HEAD
//    @ManyToMany
//    @JoinTable(
//            name = "enroll",
//            joinColumns = @JoinColumn(name="id_pelanggan"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    Set <PenggunaListrik> daftarPengguna = new HashSet<>();
//=======
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    public Long getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(Long userid) {
        this.noInduk = userid;
//<<<<<<< HEAD
//    }
//
//    public void setDaftarPengguna(Set<PenggunaListrik> daftarPengguna) {
//        this.daftarPengguna = daftarPengguna;
//=======
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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

//<<<<<<< HEAD
//    public Set<PenggunaListrik> getDaftarPengguna() {
//        return daftarPengguna;
//    }
//=======

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}

