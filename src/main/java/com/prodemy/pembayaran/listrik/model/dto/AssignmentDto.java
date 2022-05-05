package com.prodemy.pembayaran.listrik.model.dto;

public class AssignmentDto {
    private Long idPetugas;
    private String namaPetugas;
    private Long noPengaduan;

    public Long getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(Long idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    public Long getNoPengaduan() {
        return noPengaduan;
    }

    public void setNoPengaduan(Long noPengaduan) {
        this.noPengaduan = noPengaduan;
    }
}
