package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenggunaListrikrepo extends JpaRepository<PenggunaListrik,String> {
}
