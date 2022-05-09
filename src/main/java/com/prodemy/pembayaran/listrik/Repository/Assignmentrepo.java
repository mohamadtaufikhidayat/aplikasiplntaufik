package com.prodemy.pembayaran.listrik.Repository;

import com.prodemy.pembayaran.listrik.model.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Assignmentrepo extends JpaRepository<Assignment, Long> {

//    Optional<Assignment> findByNamaPetugas(String namaPetugas);

//    @Query("Select t.namaPetugas from Assignment t " )
//    Optional<Assignment> findByNamaPetugas(String namaPetugas);


//    @Query("select distinct a.idPetugas from Assignment a where a.idPetugas = :idPetugas ")
//    Optional<Assignment> findByIdPetugas (@PathParam("idPetugas") Long idPetugas);

}
