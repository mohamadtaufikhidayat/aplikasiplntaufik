package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Assignment;
import com.prodemy.pembayaran.listrik.model.entity.PetugasPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface PetugasPengaduanrepo extends JpaRepository<PetugasPengaduan, Long> {
    @Query("select a.idPetugas from PetugasPengaduan a where a.idPetugas = :idPetugas ")
    Optional<PetugasPengaduan> findByIdPetugas (@PathParam("idPetugas") Long idPetugas);
}
