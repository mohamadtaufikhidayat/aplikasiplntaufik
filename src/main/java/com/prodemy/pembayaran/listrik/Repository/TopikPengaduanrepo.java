package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopikPengaduanrepo extends JpaRepository<TopikPengaduan,Long> {
        List<TopikPengaduan> findAllByKelompokTopik(String kelompokTopik);

        @Query(value = "select t from TopikPengaduan t where t.codeTopik like '%1' ", nativeQuery = false)
        List<TopikPengaduan> findByCodeTopik();
}

