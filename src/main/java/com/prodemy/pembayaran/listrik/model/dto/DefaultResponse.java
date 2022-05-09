package com.prodemy.pembayaran.listrik.model.dto;

public class DefaultResponse <T> {
    private String pesan;
    private T data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


