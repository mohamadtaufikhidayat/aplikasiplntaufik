package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Gangguan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Gangguanrepo extends JpaRepository<Gangguan, Long> {

    List<Gangguan> findByNoGangguan (Long noGangguan);
    List<Gangguan> findAllByNoGangguan (Long noGangguan);
}
