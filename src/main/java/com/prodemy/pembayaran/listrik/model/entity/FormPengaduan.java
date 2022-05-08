package com.prodemy.pembayaran.listrik.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_FormpPengaduan")
public class FormPengaduan {
    @Id
    @GeneratedValue(generator = "sequencepengaduan")
    @GenericGenerator(
            name = "sequencepengaduan",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "complaint_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1201"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long noPengaduan;
    @ManyToOne
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik IdpenggunaListrik;
    @Column
    private String alamat;
    @Column
    private String deskripsi;
    @Column
//<<<<<<< HEAD
//    private byte foto;
//    //    @ManyToOne
////    @JoinColumn(name="IdUser")
////    private User Iduser;
//
////    @ManyToOne
////    @JoinColumn(name="codeTopik")
////    private TopikPengaduan codeTopik;
//=======
    private String status;
    @ManyToOne
    @JoinColumn(name = "KodeTopik")
    public TopikPengaduan kodeTopik;
    @ManyToOne
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik IdpenggunaListrik;

//    @Enumerated(EnumType.ORDINAL)
//    public NamaTopik namaTopik;
//
//    public NamaTopik getNamaTopik() {
//        return namaTopik;
//    }
//
//    public void setNamaTopik(NamaTopik namaTopik) {
//        this.namaTopik = namaTopik;
//    }

    public TopikPengaduan getKodeTopik() {
        return kodeTopik;
    }

    public void setKodeTopik(TopikPengaduan kodeTopik) {
        this.kodeTopik = kodeTopik;
    }
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    public Long getNoPengaduan() {
        return noPengaduan;
    }

    public void setNoPengaduan(Long noPengaduan) {
        this.noPengaduan = noPengaduan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public PenggunaListrik getIdpenggunaListrik() {
        return IdpenggunaListrik;
    }

    public void setIdpenggunaListrik(PenggunaListrik idpenggunaListrik) {
        IdpenggunaListrik = idpenggunaListrik;
    }

//<<<<<<< HEAD
//
////    public TopikPengaduan getCodeTopik() {
////        return codeTopik;
////    }
//
////    public void setCodeTopik(TopikPengaduan codeTopik) {
////        this.codeTopik = codeTopik;
////    }
//=======
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}