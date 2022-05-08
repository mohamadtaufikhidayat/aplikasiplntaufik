package com.prodemy.pembayaran.listrik.model.dto;

//<<<<<<< HEAD
//=======
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
public class FormPengaduanDto {
    private Long IdpenggunaListrik;
    private Long noPengaduan;
    private String alamat;
    private String deskripsi;
//<<<<<<< HEAD
//    private byte foto;
//    private Long IdpenggunaListrik;
////    private Long codeTopik;
//=======
    private String status;
    private String kodeTopik;

    public String getKodeTopik() {
        return kodeTopik;
    }

    public void setKodeTopik(String kodeTopik) {
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

//<<<<<<< HEAD
    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

//=======
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    public Long getIdpenggunaListrik() {
        return IdpenggunaListrik;
    }

    public void setIdpenggunaListrik(Long idpenggunaListrik) {
        IdpenggunaListrik = idpenggunaListrik;
    }

//<<<<<<< HEAD
//    public Long getCodeTopik() {
//        return codeTopik;
//    }
//
//    public void setCodeTopik(Long codeTopik) {
//        this.codeTopik = codeTopik;
//    }
//=======
    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
