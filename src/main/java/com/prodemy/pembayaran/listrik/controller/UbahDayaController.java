package com.prodemy.pembayaran.listrik.controller;


import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.Repository.UbahDayarepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.UbahDayaDto;
import com.prodemy.pembayaran.listrik.model.entity.UbahDaya;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UbahDaya")
public class UbahDayaController {
    final private UbahDayarepo ubahDayarepo;
    final private DataPelRepo penggunaListrikrepo;


    public UbahDayaController(UbahDayarepo ubahDayarepo, DataPelRepo penggunaListrikrepo) {
        this.ubahDayarepo = ubahDayarepo;
        this.penggunaListrikrepo=penggunaListrikrepo;
    }
    @PostMapping("/permintaanUbahDaya")
    public UbahDayaDto[] addUbahDaya(@RequestBody UbahDayaDto[] listbanyak){
        for(UbahDayaDto m : listbanyak){
            ubahDayarepo.save(conversiDtoToEntity(m));
        }
        return listbanyak;
    }
    @PostMapping("/cekpermintaan")//methode buat login
    public DefaultResponse<UbahDaya> cekpermintaan(@RequestBody UbahDaya ubahDaya){
        DefaultResponse<UbahDaya> responpermintaan=new DefaultResponse <>();
        Optional<UbahDaya> optional=ubahDayarepo.findById(ubahDaya.getNoUrut());
        if(optional.isPresent()){
            responpermintaan.setPesan("permintaan sudah dilakukan mohon tunggu tim Coustumer Service kami mengghubungi anda untuk verivikasi");
            responpermintaan.setData(ubahDayarepo.findById(ubahDaya.getNoUrut()).get());

        }else{
            responpermintaan.setPesan("permintaan pasang baru belum dilakukan silahkan lakukan permintaan pasang baru");
            responpermintaan.setData(null);
        }
        return responpermintaan;
    }
    @PostMapping("/permintaan")
    public DefaultResponse<UbahDayaDto> permintaan(@RequestBody UbahDayaDto ubahDayaDto){
        DefaultResponse<UbahDayaDto>respone=new DefaultResponse<>();
        Optional<UbahDaya>optional=ubahDayarepo.findById(ubahDayaDto.getNoUrut());
        if(optional.isEmpty()){
            respone.setPesan("Permintaan telah ditampung mohon tunggu tim Coustumer Service kami mengghubungi anda untuk verivikasi");
            respone.setData(ubahDayaDto);
            ubahDayarepo.save(conversiDtoToEntity(ubahDayaDto));
        }else{
            respone.setPesan("Reques permintaan Gagal");
        }
        return respone;
    }
    @PostMapping("/upadtepermintaan/admin")
    public DefaultResponse<UbahDayaDto> updateDatepermintaan(@RequestBody UbahDayaDto ubahDayaDto){
        DefaultResponse<UbahDayaDto>respone=new DefaultResponse<>();
        Optional<UbahDaya>optional=ubahDayarepo.findById(ubahDayaDto.getNoUrut());
        if(optional.isPresent()){
            respone.setPesan("Update data permintaan berhasil mohon admin cek kembali data apakah sudah sesuai");
            respone.setData(ubahDayaDto);
            ubahDayarepo.save(conversiDtoToEntity(ubahDayaDto));
        }else{
            respone.setPesan("permintaan tidak ditemukan atau tidak tidak ada dalam daftar, mohon admin cek kembali");
        }
        return respone;
    }
    @GetMapping("/DaftarPemintaan/{namaPengguna}/{alamat}")
    public List<UbahDaya> searchNamaCalonPengguna(@PathVariable String namaPengguna, @PathVariable String alamat){
        List<UbahDaya>list=listdataEntity();
        UbahDayaDto vari = new UbahDayaDto();
        List<UbahDaya>listsearchBynama=new ArrayList<>();
        for(UbahDaya m:list){
            UbahDayaDto n = conversiEntityToDto(m);
            if(((n.getNamaPengguna().toLowerCase()).matches((namaPengguna+".*").toLowerCase()))&&((n.getAlamat().toLowerCase()).matches((alamat+".*").toLowerCase()))){
                vari=n;
                listsearchBynama.add(m);
            }
        }
        return listsearchBynama;
    }
    @GetMapping("/DaftarPemintaan/idPenggunaListrik/{idPenggunaListrik}")
    public List<UbahDayaDto> searchByidPenggunaListrik(@PathVariable String idPenggunaListrik){
        List<UbahDayaDto>list=listdata();
        UbahDayaDto vari = new UbahDayaDto();
        List<UbahDayaDto>listByidPenggunaListrik=new ArrayList<>();
        for(UbahDayaDto m:list){
            if((String.valueOf(m.getIdPenggunaListrik())).matches(idPenggunaListrik+".*")){
                vari=m;
                listByidPenggunaListrik.add(m);
            }
        }
        return listByidPenggunaListrik;
    }
    public List<UbahDayaDto>listdata(){
        List<UbahDayaDto>list=new ArrayList<>();
        for(UbahDaya m :ubahDayarepo.findAll()){
            list.add(conversiEntityToDto(m));
        }
        return list;
    }
    public List<UbahDaya> listdataEntity(){
        List<UbahDaya>listEntity=new ArrayList<>();
        for(UbahDaya m :ubahDayarepo.findAll()){
            listEntity.add(m);
        }
        return listEntity;
    }
    public UbahDaya conversiDtoToEntity(UbahDayaDto ubahDayaDto){
        UbahDaya ubahDaya = new UbahDaya();
        ubahDaya.setNoUrut(ubahDayaDto.getNoUrut());
        if(penggunaListrikrepo.findById(ubahDayaDto.getIdPenggunaListrik()).isPresent()){
            ubahDaya.setIdPenggunaListrik(penggunaListrikrepo.findById(ubahDayaDto.getIdPenggunaListrik()).get());
        }
        ubahDaya.setJenisPenggunaubah(ubahDayaDto.getJenisPenggunaubah());
        ubahDaya.setDayaBaru(ubahDayaDto.getDayaBaru());
        ubahDaya.setKontak(ubahDayaDto.getKontak());
        ubahDaya.setStatus(ubahDayaDto.getStatus());
        return ubahDaya;
    }
    public UbahDayaDto conversiEntityToDto(UbahDaya ubahDaya){
        UbahDayaDto ubahDayaDto = new UbahDayaDto();
        ubahDayaDto.setNoUrut(ubahDaya.getNoUrut());
        ubahDayaDto.setIdPenggunaListrik(ubahDaya.getIdPenggunaListrik().getIdPengguna());
        ubahDayaDto.setNamaPengguna(ubahDaya.getIdPenggunaListrik().getNamaPengguna());
        ubahDayaDto.setJenisPengguna(ubahDaya.getIdPenggunaListrik().getIdJenis().getJenis());
        ubahDayaDto.setDaya(ubahDaya.getIdPenggunaListrik().getIdJenis().getDaya());
        ubahDayaDto.setAlamat(ubahDaya.getIdPenggunaListrik().getAlamat());
        ubahDayaDto.setJenisPenggunaubah(ubahDaya.getJenisPenggunaubah());
        ubahDayaDto.setDayaBaru(ubahDaya.getDayaBaru());
        ubahDayaDto.setKontak(ubahDaya.getKontak());
        ubahDayaDto.setStatus(ubahDaya.getStatus());
        return ubahDayaDto;
    }
}
