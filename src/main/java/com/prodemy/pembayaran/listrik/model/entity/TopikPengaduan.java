package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_TopikPengaduan")
public class TopikPengaduan {
    @Id
    @Column
    private Long codeTopik;
    @Column
    private String kelompokTopik;
    @Column
    private String namaTopik;

    public Long getCodeTopik() {
        return codeTopik;
    }

    public void setCodeTopik(Long codeTopik) {
        this.codeTopik = codeTopik;
    }

    public String getKelompokTopik() {
        return kelompokTopik;
    }

    public void setKelompokTopik(String kelompokTopik) {
        this.kelompokTopik = kelompokTopik;
    }

    public String getNamaTopik() {
        return namaTopik;
    }

    public void setNamaTopik(String namaTopik) {
        this.namaTopik = namaTopik;
    }
    //    @ManyToOne
//    @JoinColumn(name="noPengaduan")
//    private FormPengaduan formPengaduan;
}
