package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;

@Entity
@Table(name="t_tagihan")
public class Tagihan {

    @Id
    @Column//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noTagihan;
<<<<<<< HEAD

=======
//    @OneToOne//fk
//    @JoinColumn(name="noTransaksi")
//    private Transaksi noTransaksi;
    @ManyToOne//fk
    @JoinColumn(name="IdUser")
    private User idUser;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    @ManyToOne//fk
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik idPenggunaListrik;

<<<<<<< HEAD
    @OneToOne
    @JoinColumn(name = "noUrut")
    private CatatMeter noUrut;
    @Column(name = "bulan")
    private String bulan;
    @Column(name = "biaya")
=======
    @Column
//    private Date tanggal;
    private String bulan;
    @Column
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    private Long biaya;
    @Column(name = "kwh")
    private Long kwh;
    @Column
    private String metodePembayaran;
    @Column
    private String status;
    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

<<<<<<< HEAD
    public CatatMeter getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(CatatMeter noUrut) {
        this.noUrut = noUrut;
=======
    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    }

    public PenggunaListrik getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(PenggunaListrik idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

<<<<<<< HEAD
=======
//    public Date getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(Date tanggal) {
//        this.tanggal = tanggal;
//    }


>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public long getBiaya() {
        return biaya;
    }

    public void setBiaya(long biaya) {
        this.biaya = biaya;
    }

    public long getKwh() {
        return kwh;
    }

    public void setKwh(long kwh) {
        this.kwh = kwh;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}