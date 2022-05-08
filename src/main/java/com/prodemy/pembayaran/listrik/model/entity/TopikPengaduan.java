package com.prodemy.pembayaran.listrik.model.entity;

import javax.persistence.*;

@Entity
@Table(name="t_TopikPengaduan")
public class TopikPengaduan {
    @Id
    @Column
    private String codeTopik;
    @Column
    private String kelompokTopik;
    @Column
    private String namaTopik;
//    @ManyToOne
//    @JoinColumn(name="noPengaduan")
//    private FormPengaduan formPengaduan;

//    public FormPengaduan getFormPengaduan() {
//        return formPengaduan;
//    }
//
//    public void setFormPengaduan(FormPengaduan formPengaduan) {
//        this.formPengaduan = formPengaduan;
//    }

    public String getCodeTopik() {
        return codeTopik;
    }

    public void setCodeTopik(String codeTopik) {
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

}