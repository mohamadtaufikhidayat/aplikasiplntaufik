package com.prodemy.pembayaran.listrik.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_gang")
public class Gangguan {
    @Id
    @GeneratedValue(generator = "sequencepelangaan" )
    @GenericGenerator(
            name = "sequencepelanggan",strategy = "123",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "1",value = "1"),
                    @org.hibernate.annotations.Parameter(name = "initial_value",value = "12031"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "kdgang",unique = true)
    private Long id;
    @Column(name = "kwil")
    private String wilayah;

    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());

    @Column(name = "ksam")
    private String sampai;

    @Column(name = "ket")
    private String Keterangan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getSampai() {
        return sampai;
    }

    public void setSampai(String sampai) {
        this.sampai = sampai;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }
}
