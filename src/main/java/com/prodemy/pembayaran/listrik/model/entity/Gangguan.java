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
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1321"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "no_gangguan")
    private Long noGangguan;
    @Column(name = "lokasi")
    private String lokasi;

    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());

    @Column(name = "status")
    private Boolean status;

    @Column(name = "deskripsi")
    private String deskripsi;

    public Long getNoGangguan() {
        return noGangguan;
    }

    public void setNoGangguan(Long noGangguan) {
        this.noGangguan = noGangguan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
