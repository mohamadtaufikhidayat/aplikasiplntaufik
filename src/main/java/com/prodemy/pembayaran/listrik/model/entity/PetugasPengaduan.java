package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_petugas_pengaduan")
public class PetugasPengaduan {
    @Id
    @Column
    private Long idPetugas;
    private String nama;

    public Long getIdPetugas() {
        return idPetugas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setIdPetugas(Long idPetugas) {
        this.idPetugas = idPetugas;
    }
}
