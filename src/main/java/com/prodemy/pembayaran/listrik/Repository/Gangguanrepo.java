package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Gangguan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface Gangguanrepo extends JpaRepository<Gangguan, Long> {

    List<Gangguan> findByNoGangguan (Long noGangguan);
    List<Gangguan> findAllByNoGangguan (Long noGangguan);
    @Modifying
    @Query("UPDATE Gangguan f SET f.status = false WHERE f.noGangguan =:noGangguan ")
    int updateStatus (Long noGangguan);

//    @Query("select t.status from Gangguan t where t.status like '%selesai%' ")
//    List<Gangguan> findByStatus ();

    List<Gangguan> findByLokasiEqualsIgnoreCaseAndStatusIsTrue (String lokasi);

    @Query("select t.status from Gangguan t where t.status = true and t.lokasi = :lokasi")
    Optional<Gangguan> findByStatusAndLokasiEqualsIgnoreCase (@PathParam("lokasi") String lokasi);

    @Query("select t from Gangguan t where t.status = true and t.lokasi = :lokasi")
    List<Gangguan> findByStatusAndLokasi (@PathParam("lokasi") String lokasi);
}
