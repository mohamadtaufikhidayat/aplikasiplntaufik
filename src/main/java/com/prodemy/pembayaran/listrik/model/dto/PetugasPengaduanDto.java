package com.prodemy.pembayaran.listrik.model.dto;

public class PetugasPengaduanDto {
    private Long noPengaduan;
    private String status;

    public Long getNoPengaduan() {
        return noPengaduan;
    }

    public void setNoPengaduan(Long noPengaduan) {
        this.noPengaduan = noPengaduan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
