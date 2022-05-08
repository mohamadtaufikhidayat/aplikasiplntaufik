package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import java.util.Optional;

public interface DataPelRepo extends JpaRepository<PenggunaListrik,Long> {

    @Query("select r from PenggunaListrik r where r.idPengguna = :idPengguna")
<<<<<<< HEAD
    Optional<PenggunaListrik> findByIdPengguna(@PathParam("idPelanggan")Long idPengguna);

    @Query(value="SELECT daya as daya, jenis_pengguna as jenis FROM t_plistrik WHERE id_pengguna = :id_pengguna" , nativeQuery=true)
    TestProjection findJenisByIdPengguna(Long id_pengguna);
=======
    Optional<PenggunaListrik> findByIdPengguna(@PathParam("idPelanggan") Long idPengguna);

    Optional<PenggunaListrik> findAllByAlamat(String alamat);

    List<PenggunaListrik> findByAlamat(String alamat);

    Optional<PenggunaListrik> findPenggunaListrikByAlamat(String alamat);

    @Query("select r from PenggunaListrik r where r.idPengguna = :idPengguna")
    Optional<PenggunaListrik> findPenggunaListriksByIdPengguna (@PathParam("idPengguna") Long idPengguna);
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
