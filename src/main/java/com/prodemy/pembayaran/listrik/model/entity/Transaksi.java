package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_transaksi")
public class Transaksi {
    @Id
    @Column//pk
    private Long noTransaksi;
    @OneToOne//fk
    @JoinColumn(name="noTagihan")
    private Tagihan noTagihan;
    @ManyToOne
    @JoinColumn(name="IdPenggunaListrik")
    private PenggunaListrik idPenggunaListrik;
    @ManyToOne
    @JoinColumn(name="IdUser")
    private User idUser;
    @Column
    private Date tanggal;
    @Column
    private Long biaya;

    public Long getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(Long noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Tagihan getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Tagihan noTagihan) {
        this.noTagihan = noTagihan;
    }

    public PenggunaListrik getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(PenggunaListrik idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
