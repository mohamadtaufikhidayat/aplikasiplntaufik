package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface FormPengaduanrepo extends JpaRepository<FormPengaduan,Long> {

//    @Query(value = "UPDATE FormPengaduan SET status = 'Sedang ditindak-lanjuti' WHERE noPengaduan = :noPengaduan", nativeQuery = false)
//    FormPengaduan findByNoPengaduan (Long noPengaduan);


    @Modifying
    @Query("UPDATE FormPengaduan f SET f.status = 'Sedang ditindak-lanjuti' WHERE f.noPengaduan =:noPengaduan ")
    int updateStatus(Long noPengaduan);
    @Modifying
    @Query("UPDATE FormPengaduan f SET f.status = 'Pengaduan selesai, masalah telah diatasi' WHERE f.noPengaduan =:noPengaduan ")
    int updateStatus2(Long noPengaduan);


}
