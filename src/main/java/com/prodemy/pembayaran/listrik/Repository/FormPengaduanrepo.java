package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface FormPengaduanrepo extends JpaRepository<FormPengaduan,Long> {

    @Query(value = "UPDATE FormPengaduan SET status = 'Sedang ditindak-lanjuti' WHERE noPengaduan = :noPengaduan", nativeQuery = false)
    FormPengaduan findByNoPengaduan (Long noPengaduan);

}
