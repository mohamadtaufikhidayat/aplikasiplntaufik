package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenggunaListrikrepo extends JpaRepository<PenggunaListrik,String> {
    @Query(value="SELECT daya as daya, jenis_pengguna as jenis FROM t_plistrik WHERE id_pengguna = :id_pengguna" , nativeQuery=true)
    TestProjection findJenisByIdPengguna(Long id_pengguna);

}
