package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.JenisPelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JenisPelangganRepo extends JpaRepository<JenisPelanggan, Long> {
}
