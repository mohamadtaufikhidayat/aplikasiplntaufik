package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Admin;
import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    @Query("select x from Admin x where x.no_aplikasi =:no_Pegawai")
    Optional<Admin> findByNo_aplikasi(@PathParam("no_pegawi")Long no_Pegawai);
}
