package com.prodemy.pembayaran.listrik.model.dto;

public class JenisPelangganDto {
    private Long idJenis;
    private String jenis;

    private String daya;

    private Long tarif;

    public Long getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Long idJenis) {
        this.idJenis = idJenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDaya() {
        return daya;
    }

    public void setDaya(String daya) {
        this.daya = daya;
    }

    public Long getTarif() {
        return tarif;
    }

    public void setTarif(Long tarif) {
        this.tarif = tarif;
    }
}
