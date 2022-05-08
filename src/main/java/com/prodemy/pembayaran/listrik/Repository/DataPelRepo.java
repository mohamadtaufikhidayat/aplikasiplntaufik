package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface DataPelRepo extends JpaRepository<PenggunaListrik,Long> {

    @Query("select r from PenggunaListrik r where r.idPengguna = :idPengguna")
    Optional<PenggunaListrik> findByIdPengguna(@PathParam("idPelanggan") Long idPengguna);

    Optional<PenggunaListrik> findAllByAlamat(String alamat);

    List<PenggunaListrik> findByAlamat(String alamat);

    Optional<PenggunaListrik> findPenggunaListrikByAlamat(String alamat);

    @Query("select r from PenggunaListrik r where r.idPengguna = :idPengguna")
    Optional<PenggunaListrik> findPenggunaListriksByIdPengguna (@PathParam("idPengguna") Long idPengguna);
}
