package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Tagihan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface Tagihanrepo extends JpaRepository<Tagihan,Long> {
    Optional<Tagihan> findByIdPenggunaListrikAndBulan(String n, String k);

    List<Tagihan> findByIdPenggunaListrik(String idPenggunaListrik);
}
