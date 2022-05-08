package com.prodemy.pembayaran.listrik.controller;

import com.prodemy.pembayaran.listrik.Repository.PasangBarurepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.PasangBaruDto;
import com.prodemy.pembayaran.listrik.model.entity.PasangBaru;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PasangBaru")
public class PasangBaruController {
    final private PasangBarurepo pasangBarurepo;


    public PasangBaruController(PasangBarurepo pasangBarurepo) {
        this.pasangBarurepo = pasangBarurepo;
    }
    @PostMapping("/permintaanPasangBaru")
    public PasangBaruDto[] addPasangBaru(@RequestBody PasangBaruDto[] listbanyak){
        for(PasangBaruDto m : listbanyak){
            pasangBarurepo.save(conversiDtoToEntity(m));
        }
        return listbanyak;
    }
    @PostMapping("/cekpermintaan")//methode buat login
    public DefaultResponse<PasangBaru> cekpermintaan(@RequestBody PasangBaru pasangBaru){
        DefaultResponse<PasangBaru> responpermintaan=new DefaultResponse <>();
        Optional<PasangBaru> optional=pasangBarurepo.findById(pasangBaru.getNoUrut());
        if(optional.isPresent()){
            responpermintaan.setPesan("permintaan sudah dilakukan mohon tunggu tim Coustumer Service kami mengghubungi anda untuk verivikasi");
            responpermintaan.setData(pasangBarurepo.findById(pasangBaru.getNoUrut()).get());

        }else{
            responpermintaan.setPesan("permintaan pasang baru belum dilakukan silahkan lakukan permintaan pasang baru");
            responpermintaan.setData(null);
        }
        return responpermintaan;
    }
    @PostMapping("/permintaan")
    public DefaultResponse<PasangBaruDto> permintaan(@RequestBody PasangBaruDto pasangBaruDto){
        DefaultResponse<PasangBaruDto>respone=new DefaultResponse<>();
        Optional<PasangBaru>optional=pasangBarurepo.findById(pasangBaruDto.getNoUrut());
        if(optional.isEmpty()){
            respone.setPesan("Permintaan telah ditampung mohon tunggu tim Coustumer Service kami mengghubungi anda untuk verivikasi");
            respone.setData(pasangBaruDto);
            pasangBarurepo.save(conversiDtoToEntity(pasangBaruDto));
        }else{
            respone.setPesan("Reques Permintaan Gagal");
        }
        return respone;
    }
    @PostMapping("/upadatedatapermintaan/admin")
    public DefaultResponse<PasangBaruDto> updateDatapermintaan(@RequestBody PasangBaruDto pasangBaruDto){
        DefaultResponse<PasangBaruDto>respone=new DefaultResponse<>();
        Optional<PasangBaru>optional=pasangBarurepo.findById(pasangBaruDto.getNoUrut());
        if(optional.isPresent()){
            respone.setPesan("Update data permintaan berhasil mohon admin cek kembali data apakah sudah sesuai");
            respone.setData(pasangBaruDto);
            pasangBarurepo.save(conversiDtoToEntity(pasangBaruDto));
        }else{
            respone.setPesan("permintaan tidak ditemukan atau tidak tidak ada dalam daftar, mohon admin cek kembali");
        }
        return respone;
    }
    @GetMapping("/DaftarPemintaan/{namaCalonPengguna}/{alamat}")
    public List<PasangBaruDto> searchNamaCalonPengguna(@PathVariable String namaCalonPengguna,@PathVariable String alamat){
        List<PasangBaruDto>list=listdata();
        PasangBaruDto vari = new PasangBaruDto();
        List<PasangBaruDto>listsearchBynama=new ArrayList<>();
        for(PasangBaruDto m:list){
            if(((m.getNamaCalonPengguna().toLowerCase()).matches((namaCalonPengguna+".*").toLowerCase()))&&((m.getAlamat().toLowerCase()).matches((alamat+".*").toLowerCase()))){
                vari=m;
                listsearchBynama.add(vari);
            }
        }
        return listsearchBynama;
    }
    public List<PasangBaruDto>listdata(){
        List<PasangBaruDto>list=new ArrayList<>();
        for(PasangBaru m :pasangBarurepo.findAll()){
            list.add(conversiEntityToDto(m));
        }
        return list;
    }
    public List<PasangBaru> listdataEntity(){
        List<PasangBaru>listEntity=new ArrayList<PasangBaru>();
        for(PasangBaru m :pasangBarurepo.findAll()){
            listEntity.add(m);
        }
        return listEntity;
    }
    public PasangBaru conversiDtoToEntity(PasangBaruDto pasangBaruDto){
        PasangBaru pasangBaru = new PasangBaru();
        pasangBaru.setNoUrut(pasangBaruDto.getNoUrut());
        pasangBaru.setNamaCalonPengguna(pasangBaruDto.getNamaCalonPengguna());
        pasangBaru.setAlamat(pasangBaruDto.getAlamat());
        pasangBaru.setJenisPengguna(pasangBaruDto.getJenisPengguna());
        pasangBaru.setDaya(pasangBaruDto.getDaya());
        pasangBaru.setKontak(pasangBaruDto.getKontak());
        pasangBaru.setStatus(pasangBaruDto.getStatus());
        return pasangBaru;
    }
    public PasangBaruDto conversiEntityToDto(PasangBaru pasangBaru){
        PasangBaruDto pasangBaruDto = new PasangBaruDto();
        pasangBaruDto.setNoUrut(pasangBaru.getNoUrut());
        pasangBaruDto.setNamaCalonPengguna(pasangBaru.getNamaCalonPengguna());
        pasangBaruDto.setAlamat(pasangBaru.getAlamat());
        pasangBaruDto.setJenisPengguna(pasangBaru.getJenisPengguna());
        pasangBaruDto.setDaya(pasangBaru.getDaya());
        pasangBaruDto.setKontak(pasangBaru.getKontak());
        pasangBaruDto.setStatus(pasangBaru.getStatus());
        return pasangBaruDto;
    }
}
