package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface TopikPengaduanrepo extends JpaRepository<TopikPengaduan,Long> {
        List<TopikPengaduan> findAllByKelompokTopik(String kelompokTopik);

        @Query(value = "select t from TopikPengaduan t where t.codeTopik like '%1' ", nativeQuery = false)
        List<TopikPengaduan> findByCodeTopik();

        @Query("select r from TopikPengaduan r where r.codeTopik = :codeTopik")
        Optional<TopikPengaduan> findByCodeTopik(@PathParam("codeTopik")String codeTopik);
//        @Query("select r from TopikPengaduan r where r.namaTopik = :namaTopik")
//        Optional<TopikPengaduan> findByNamaTopik(@PathParam("namaTopik")String namaTopik);
}

