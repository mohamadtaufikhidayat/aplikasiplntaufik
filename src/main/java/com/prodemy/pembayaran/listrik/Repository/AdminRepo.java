package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Admin;
<<<<<<< HEAD
=======
import com.prodemy.pembayaran.listrik.model.entity.User;
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Long> {

<<<<<<< HEAD
    @Query("select x from Admin x where x.no_aplikasi =:no_Pegawai")
    Optional<Admin> findByNo_aplikasi(@PathParam("no_pegawi")Long no_Pegawai);
=======
    @Query("select p from User p where p.email = :email")
    Optional<User> findByEmail(@PathParam("email")String email);

    @Query ("select x from Admin x where x.no_aplikasi = :no_Pegawai")
    Optional<Admin> findByNo_aplikasi(@PathParam("no_pegawai")Long no_Pegawai);
>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
