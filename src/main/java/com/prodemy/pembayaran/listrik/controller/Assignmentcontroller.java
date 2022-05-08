package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.Assignmentrepo;
import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import com.prodemy.pembayaran.listrik.Repository.PetugasPengaduanrepo;
import com.prodemy.pembayaran.listrik.model.dto.AssignmentDto;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.entity.Assignment;
import com.prodemy.pembayaran.listrik.model.entity.FormPengaduan;
import com.prodemy.pembayaran.listrik.model.entity.PetugasPengaduan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/assignment")
public class Assignmentcontroller {
    private final PetugasPengaduanrepo petugasPengaduanrepo;
    private final FormPengaduanrepo formPengaduanrepo;
    private final Assignmentrepo assignmentrepo;

    public Assignmentcontroller(PetugasPengaduanrepo petugasPengaduanrepo, FormPengaduanrepo formPengaduanrepo, Assignmentrepo assignmentrepo) {
        this.petugasPengaduanrepo = petugasPengaduanrepo;
        this.formPengaduanrepo = formPengaduanrepo;
        this.assignmentrepo = assignmentrepo;
    }

    @PostMapping("/pelimpahan-pengaduan")
    public DefaultResponse<AssignmentDto> insertForm (@RequestBody AssignmentDto dto){
        DefaultResponse<AssignmentDto> response = new DefaultResponse<>();
        Assignment entity = convertToEntity(dto);
        Optional<PetugasPengaduan> optional = petugasPengaduanrepo.findByIdPetugas(dto.getIdPetugas());
        Optional<FormPengaduan> optional1 = formPengaduanrepo.findById(dto.getNoPengaduan());
        if(optional.isPresent() && optional1.isPresent()){
            assignmentrepo.save(entity);
            response.setPesan("Pengaduan berhasil dilimpahkan kepada petugas");
            response.setData(dto);
        } else{
            response.setPesan("Nomor Id Petugas Atau Nomor Pengaduan Salah!");
        }
        return response;
    }
    private Assignment convertToEntity(AssignmentDto dto){
        Assignment assignment = new Assignment();
        if(formPengaduanrepo.findById(dto.getNoPengaduan()).isPresent()){
            FormPengaduan formPengaduan =  formPengaduanrepo.findById(dto.getNoPengaduan()).get();
            assignment.setNoPengaduan(formPengaduan);
        }
        if(petugasPengaduanrepo.findById(dto.getIdPetugas()).isPresent()){
            PetugasPengaduan petugas =  petugasPengaduanrepo.findById(dto.getIdPetugas()).get();
            assignment.setIdPetugas(petugas);
        }
        return assignment;
    }
}
