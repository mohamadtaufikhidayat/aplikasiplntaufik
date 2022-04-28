package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;

@Entity
@Table(name="t_FormpPengaduan")
public class FormPengaduan {
    @Id
    @Column
    private Long noPengaduan;
    @Column
    private String alamat;
    @Column
    private String deskripsi;
    @Column
    private byte foto;
    //    @ManyToOne
//    @JoinColumn(name="IdUser")
//    private User Iduser;
    @ManyToOne
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik IdpenggunaListrik;

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