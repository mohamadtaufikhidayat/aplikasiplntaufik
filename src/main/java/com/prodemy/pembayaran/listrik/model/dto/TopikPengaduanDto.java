package com.prodemy.pembayaran.listrik.model.dto;


public class TopikPengaduanDto {
    private Long codeTopik;
    private String kelompokTopik;
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
}
