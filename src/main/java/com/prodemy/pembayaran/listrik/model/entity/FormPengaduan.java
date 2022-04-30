package com.prodemy.pembayaran.listrik.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_FormpPengaduan")
public class FormPengaduan {
    @Id
//    @GeneratedValue(generator = "sequencepengaduan" )
//    @GenericGenerator(
//            name = "sequencepengaduan",strategy = "123",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "1",value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value",value = "12031"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    @GeneratedValue(generator = "sequencepengaduan")
    @GenericGenerator(
            name = "sequencepengaduan",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
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
    private byte foto;
    //    @ManyToOne
//    @JoinColumn(name="IdUser")
//    private User Iduser;

//    @ManyToOne
//    @JoinColumn(name="codeTopik")
//    private TopikPengaduan codeTopik;

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

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public PenggunaListrik getIdpenggunaListrik() {
        return IdpenggunaListrik;
    }

    public void setIdpenggunaListrik(PenggunaListrik idpenggunaListrik) {
        IdpenggunaListrik = idpenggunaListrik;
    }


//    public TopikPengaduan getCodeTopik() {
//        return codeTopik;
//    }

//    public void setCodeTopik(TopikPengaduan codeTopik) {
//        this.codeTopik = codeTopik;
//    }
}