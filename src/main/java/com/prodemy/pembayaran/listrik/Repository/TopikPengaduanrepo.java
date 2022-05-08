package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.TopikPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

import java.util.List;

public interface TopikPengaduanrepo extends JpaRepository<TopikPengaduan,Long> {
<<<<<<< HEAD
//    Optional<TopikPengaduan> findByKelompokTopik(String n);
        List<TopikPengaduan> findAllByKelompokTopik(String kelompokTopik);
=======
        List<TopikPengaduan> findAllByKelompokTopikIgnoreCase(String kelompokTopik);
        List<TopikPengaduan> findAllByNamaTopikIsContainingIgnoreCase(String namaTopik);

        @Query(value = "select t from TopikPengaduan t where t.codeTopik like '%1' ", nativeQuery = false)
        List<TopikPengaduan> findByCodeTopik();

        @Query("select r from TopikPengaduan r where r.codeTopik = :codeTopik")
        Optional<TopikPengaduan> findByCodeTopik(@PathParam("codeTopik")String codeTopik);
//        @Query("select r from TopikPengaduan r where r.namaTopik = :namaTopik")
//        Optional<TopikPengaduan> findByNamaTopik(@PathParam("namaTopik")String namaTopik);
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}

