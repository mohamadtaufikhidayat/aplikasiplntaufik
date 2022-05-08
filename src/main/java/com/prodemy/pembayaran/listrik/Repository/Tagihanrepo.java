package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Tagihan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.lang.ref.Reference;
import java.util.Date;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import java.util.List;
import java.util.Optional;

@Repository
public interface Tagihanrepo extends JpaRepository<Tagihan,Long> {
    Optional<Tagihan> findByIdPenggunaListrikIdPenggunaAndBulan(Long n, String k);

<<<<<<< HEAD
    List<Tagihan> findAllByIdPenggunaListrikIdPenggunaAndBulan(Long n, String k);

=======
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    List<Tagihan> findByIdPenggunaListrikIdPengguna(Long idPengguna);

}
