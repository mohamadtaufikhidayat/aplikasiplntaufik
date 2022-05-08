package com.prodemy.pembayaran.listrik.model.dto;

public class TransaksiDto {
    private Long noTransaksi;
    private Long noTagihan;
    private Long idNoPelanggan;
    //    private String idPenggunaListrik;
    private Long idUser;
    private Long idPenggunaListrik;
    //    private Date tanggal;
    private String namaPenggunaListrik;
    private Long daya;
    private String bulan;
    private Long biaya;
    private Long kwh;
    private String status;
    private Long kwhxiduser;
    private String metodePembayaran;
    private Long noRekeningPLN;
//    private Date tanggal;
//    private Long biaya;

    public Long getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(Long noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Long getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(Long noTagihan) {
        this.noTagihan = noTagihan;
    }

    public Long getIdNoPelanggan() {
        return idNoPelanggan;
    }

    public void setIdNoPelanggan(Long idNoPelanggan) {
        this.idNoPelanggan = idNoPelanggan;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdPenggunaListrik() {
        return idPenggunaListrik;
    }

    public void setIdPenggunaListrik(Long idPenggunaListrik) {
        this.idPenggunaListrik = idPenggunaListrik;
    }

    public String getNamaPenggunaListrik() {
        return namaPenggunaListrik;
    }

    public void setNamaPenggunaListrik(String namaPenggunaListrik) {
        this.namaPenggunaListrik = namaPenggunaListrik;
    }

    public Long getDaya() {
        return daya;
    }

    public void setDaya(Long daya) {
        this.daya = daya;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }

    public Long getKwh() {
        return kwh;
    }

    public void setKwh(Long kwh) {
        this.kwh = kwh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Long getNoRekeningPLN() {
        return noRekeningPLN;
    }

    public void setNoRekeningPLN(Long noRekeningPLN) {
        this.noRekeningPLN = noRekeningPLN;
    }

    public Long getKwhxiduser() {
        return kwhxiduser;
    }

    public void setKwhxiduser(Long kwhxiduser) {
        this.kwhxiduser = kwhxiduser;
    }
}
