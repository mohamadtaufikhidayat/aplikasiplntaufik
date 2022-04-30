package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.dto.TopikPengaduanDto;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopikPengaduanrepo extends JpaRepository<TopikPengaduan,Long> {
        List<TopikPengaduan> findAllByKelompokTopik(String kelompokTopik);
//        @Query("SELECT u FROM TopikPengaduan u WHERE u.codeTopik = ?01")
//        List<TopikPengaduan> findByKelompokTopik(Long codeTopik);
//        TopikPengaduan findDistinctByKelompokTopik(String kelompokTopik);

        @Query("SELECT DISTINCT t.kelompokTopik FROM TopikPengaduan t")
        List getDistinctByKelompokTopik() ;
}

