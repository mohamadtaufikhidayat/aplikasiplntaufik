package com.prodemy.pembayaran.listrik.model.entity;

import org.hibernate.annotations.GenericGenerator;

//<<<<<<< HEAD
//import javax.persistence.*;
//
//@Entity
//@Table(name = "tb_pelanggan")
//public class Pelanggan {
//    @Id
//    @GeneratedValue(
//            generator = "sequencePelanggan",
//            strategy = GenerationType.SEQUENCE
//
//    )
//    @GenericGenerator(
//            name = "sequencePelanggan",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_sequencePelanggan"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "30001"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled-lo")
//            }
//    )
//    @Column
//    private Long noPelanggan;
//    @ManyToOne
//    @JoinColumn(name="idUser")
//    private User idUser;
//    @ManyToOne
//    @JoinColumn(name="idPenggunaListrik")
//    private PenggunaListrik idPenggunaListrik;
//
//
//    public Long getNoPelanggan() {
//        return noPelanggan;
//    }
//
//    public void setNoPelanggan(Long noPelanggan) {
//        this.noPelanggan = noPelanggan;
//    }
//
//    public User getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(User idUser) {
//        this.idUser = idUser;
//    }
//
//    public PenggunaListrik getIdPenggunaListrik() {
//        return idPenggunaListrik;
//    }
//
//    public void setIdPenggunaListrik(PenggunaListrik idPenggunaListrik) {
//        this.idPenggunaListrik = idPenggunaListrik;
//    }
//=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl ")
public class Pelanggan {
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
    private Long id ;

    private Long user;

    private Long pelanggan;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
