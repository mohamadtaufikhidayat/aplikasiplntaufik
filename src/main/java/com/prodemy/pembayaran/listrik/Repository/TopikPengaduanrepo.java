package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopikPengaduanrepo extends JpaRepository<TopikPengaduan,Long> {
//    Optional<TopikPengaduan> findByKelompokTopik(String n);
        List<TopikPengaduan> findAllByKelompokTopik(String kelompokTopik);
}

