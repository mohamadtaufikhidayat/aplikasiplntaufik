package com.prodemy.pembayaran.listrik.model.dto;

public class GangguanDto {
    Long idPengguna;
    Long noGangguan;
    String lokasi;
    String status;
    String deskripsi;

    public Long getNoGangguan() {
        return noGangguan;
    }

    public void setNoGangguan(Long noGangguan) {
        this.noGangguan = noGangguan;
    }

    public Long getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Long idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
