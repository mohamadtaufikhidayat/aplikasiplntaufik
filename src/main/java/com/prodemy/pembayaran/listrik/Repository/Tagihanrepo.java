package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Tagihan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tagihanrepo extends JpaRepository<Tagihan,Long> {
}
