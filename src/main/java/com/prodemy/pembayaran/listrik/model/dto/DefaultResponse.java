package com.prodemy.pembayaran.listrik.model.dto;

import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;

import java.util.List;

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


