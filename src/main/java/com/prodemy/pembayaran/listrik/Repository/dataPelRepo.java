package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface dataPelRepo extends JpaRepository<PenggunaListrik,Long> {

    @Query ("select x from PenggunaListrik x where x.kecamatan = :kecamatan")
    List<PenggunaListrik> findByKecamatan(@PathParam("kecamatan")String kecamatan);
    @Query("select r from PenggunaListrik r where r.idPengguna = :idPengguna")
    Optional<PenggunaListrik> findByIdPengguna(@PathParam("idPelanggan")Long idPengguna);

    @Query("select p from PenggunaListrik p where p.app.noInduk = :user_id")
    List<PenggunaListrik> findByuser(@PathParam("user_id")Long user_id);
}
