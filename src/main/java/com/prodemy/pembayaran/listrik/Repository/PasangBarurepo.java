package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PasangBaru;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasangBarurepo extends JpaRepository<PasangBaru,Long> {
}
