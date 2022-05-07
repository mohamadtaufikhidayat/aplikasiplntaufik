package com.prodemy.pembayaran.listrik.model.dto;

public class CatatMeterDto {
    private Long noUrut;
    private Long idPenggunaListrik;
    private String bulanini;
    private Long cttkwh;

    public Long getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Long noUrut) {
        this.noUrut = noUrut;
    }

    public Long getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(Long idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

    public String getBulanini() {
        return bulanini;
    }

    public void setBulanini(String bulanini) {
        this.bulanini = bulanini;
    }
    public Long getCttkwh() {
        return cttkwh;
    }

    public void setCttkwh(Long cttkwh) {
        this.cttkwh = cttkwh;
    }

}
