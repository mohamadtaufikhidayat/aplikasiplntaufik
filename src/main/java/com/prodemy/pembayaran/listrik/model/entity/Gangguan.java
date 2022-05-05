package com.prodemy.pembayaran.listrik.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_gangguan")
public class Gangguan {
    @Id
    @GeneratedValue(generator = "sequencegangguan")
    @GenericGenerator(
            name = "sequencegangguan",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "gangguan_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "121"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "no_gangguan",unique = true)
    private Long noGangguan;
    @Column(name = "lokasi")
    private String lokasi;

    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());

    @Column(name = "status")
    private String status;

    @Column(name = "deskripsi")
    private String deskripsi;

    public Long getNoGangguan() {
        return noGangguan;
    }

    public void setNoGangguan(Long id) {
        this.noGangguan = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String wilayah) {
        this.lokasi = wilayah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String sampai) {
        this.status = sampai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
