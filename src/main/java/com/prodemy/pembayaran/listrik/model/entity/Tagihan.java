package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_tagihan")
public class Tagihan {

    @Id
    @Column//pk
    private Long noTagihan;
//    @OneToOne//fk
//    @JoinColumn(name="noTransaksi")
//    private Transaksi noTransaksi;
    @ManyToOne//fk
    @JoinColumn(name="IdUser")
    private User idUser;
    @ManyToOne//fk
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik idPenggunaListrik;

    @Column
//    private Date tanggal;
    private String bulan;
    @Column
    private Long biaya;
    @Column
    private Long kwh;
    @Column
    private String status;
    @Column
    private String metodePembayaran;

    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

//    public Transaksi getNoTransaksi() {
//        return noTransaksi;
//    }
//
//    public void setNoTransaksi(Transaksi noTransaksi) {
//        this.noTransaksi = noTransaksi;
//    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public PenggunaListrik getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(PenggunaListrik idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

//    public Date getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(Date tanggal) {
//        this.tanggal = tanggal;
//    }


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
}