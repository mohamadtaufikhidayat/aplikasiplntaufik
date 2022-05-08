package com.prodemy.pembayaran.listrik.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="saldo")
public class Saldo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_acc;
    @OneToOne
    @JoinColumn(name = "no_telp")
    private Account account;

    @Column(name ="saldo")
    private Long saldo;
    @Column(name ="out")
    private Long pengeluaran;
    @Column(name = "in")
    private Long pemasukan;

    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(Long pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public Long getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(Long pemasukan) {
        this.pemasukan = pemasukan;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId_acc() {
        return id_acc;
    }

    public void setId_acc(Long id_acc) {
        this.id_acc = id_acc;
    }
}
