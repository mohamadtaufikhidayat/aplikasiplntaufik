package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User, Long> {
    @Query("select p from User p where p.email = :email")
<<<<<<< HEAD
    Optional<User> findByEmail(@PathParam("email")String email);

    @Query("select x.password from User x where x.email =:email")
    Optional<User> findByPassword(@PathParam("email")String email);

    @Query("select x.data from User x where x.email = :email")
    Optional<User> findByPegawai(@PathParam("email")String email);
}

=======
    Optional<User> findByEmail(@PathParam("email") String email);

    @Query("select x.password from User x where x.email =:email")
    Optional<User> findByPassword(@PathParam("email") String email);

    @Query("select x.data from User x where x.email = :email")
    Optional<User> findByPegawai(@PathParam("email") String email);

    @Query("select p from User p where p.email like :email")
    List<User> findByNameLike(@PathParam("email") String email);

}


>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
