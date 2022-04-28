package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface Userrepo extends JpaRepository<User, String> {
    @Query("select p from User p where p.email = :email")
    Optional<User> findByEmail(@PathParam("email")String email);
}
