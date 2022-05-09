package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FormPengaduanrepo extends JpaRepository<FormPengaduan,Long> {
    @Modifying
    @Query("UPDATE FormPengaduan f SET f.status = 'Sedang ditindak-lanjuti' WHERE f.noPengaduan =:noPengaduan ")
    int updateStatus(Long noPengaduan);
    @Modifying
    @Query("UPDATE FormPengaduan f SET f.status = 'Pengaduan selesai, masalah telah diatasi' WHERE f.noPengaduan =:noPengaduan ")
    int updateStatus2(Long noPengaduan);

    List<FormPengaduan> findAllByNoPengaduan (Long noPengaduan);
    Optional<FormPengaduan> findByNoPengaduan (Long noPengaduan);
//    Long findAByNoPengaduan (Long noPengaduan);
    Optional<FormPengaduan> getByNoPengaduan (Long noPengaduan);
}
