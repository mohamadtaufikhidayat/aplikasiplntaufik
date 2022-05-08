package com.prodemy.pembayaran.listrik.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
//<<<<<<< HEAD
//@Table(name = "tb_gang")
//public class Gangguan {
//    @Id
//    @GeneratedValue(generator = "sequencepelangaan" )
//    @GenericGenerator(
//            name = "sequencepelanggan",strategy = "123",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "1",value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value",value = "12031"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
//    @Column(name = "kdgang",unique = true)
//    private Long id;
//    @Column(name = "kwil")
//    private String wilayah;
//=======
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
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());

//<<<<<<< HEAD
//    @Column(name = "ksam")
//    private String sampai;
//
//    @Column(name = "ket")
//    private String Keterangan;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getWilayah() {
//        return wilayah;
//    }
//
//    public void setWilayah(String wilayah) {
//        this.wilayah = wilayah;
//    }
//
//    public String getSampai() {
//        return sampai;
//    }
//
//    public void setSampai(String sampai) {
//        this.sampai = sampai;
//    }
//
//    public String getKeterangan() {
//        return Keterangan;
//    }
//
//    public void setKeterangan(String keterangan) {
//        Keterangan = keterangan;
//    }
//=======
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


//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
