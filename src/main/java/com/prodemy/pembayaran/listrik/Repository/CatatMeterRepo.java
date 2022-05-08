package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.CatatMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatatMeterRepo extends JpaRepository<CatatMeter, Long> {
//    TestProjection findByIdPenggunaListrikIdPengguna(Long idPengguna);
    Optional<CatatMeter> findByNoUrutAndIdPenggunaListrikIdPengguna(Long n, Long k);
}
