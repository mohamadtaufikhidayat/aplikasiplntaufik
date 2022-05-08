package com.prodemy.pembayaran.listrik.controller;


import com.prodemy.pembayaran.listrik.Repository.Pelangganrepo;
import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;
import com.prodemy.pembayaran.listrik.Repository.Transaksirepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.Service.TransaksiService;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.TransaksiDto;
import com.prodemy.pembayaran.listrik.model.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transaksi")
public class Transaksicontroller {
    final private Transaksirepo transaksirepo;
    final private Userrepo userrepo;
    final private Tagihanrepo tagihanrepo;
    final private Pelangganrepo pelangganrepo;
    @Autowired
    private TransaksiService transaksiService;

    public Transaksicontroller(Transaksirepo transaksirepo, Userrepo userrepo, Tagihanrepo tagihanrepo,Pelangganrepo pelangganrepo) {
        this.transaksirepo = transaksirepo;
        this.userrepo = userrepo;
        this.tagihanrepo = tagihanrepo;
        this.pelangganrepo=pelangganrepo;
    }

    @PostMapping("/savecoba")
    public DefaultResponse<TransaksiDto> saveTryDefaultres(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi=conversiDtoToEntity(transaksiDto);
        DefaultResponse<TransaksiDto>response=new DefaultResponse<>();
        if((transaksi.getNoTagihan().getStatus()).equals(null)
                &&transaksi.getNoTagihan().getBiaya()==transaksiDto.getBiaya()
                &&transaksi.getMetodePembayaran().getNoRekPLN()==transaksiDto.getNoRekeningPLN()){
            response.setPesan("transaksi berhasil");
            transaksiDto.setStatusTransaksi("Transaksi Berhasil");
            response.setData(transaksiDto);
            transaksirepo.save(transaksi);
        }else{
            response.setPesan("transaksi gagal");
        }
        return response;
    }
    @PostMapping("/savecobatrx")
    public DefaultResponse<TransaksiDto> saveTrycobatrx(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi=conversiDtoToEntity(transaksiDto);
        DefaultResponse<TransaksiDto>response=new DefaultResponse<>();
        if((transaksi.getNoTagihan().getStatus()).equals(null)&&transaksi.getNoTagihan().getBiaya()==transaksiDto.getBiaya()&&transaksi.getMetodePembayaran().getNoRekPLN()==transaksiDto.getNoRekeningPLN()){
            response.setPesan("transaksi berhasil");
            response.setData(transaksiDto);
        }else{
            response.setPesan("transaksi gagal");
        }
        transaksiService.insertDataTransdeff(transaksi, transaksiDto);
        return response;
    }
    @PostMapping("/save")
    public TransaksiDto saveTryy(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi=conversiDtoToEntity(transaksiDto);
        transaksirepo.save(transaksi);
        return conversiEntityToDto(transaksi);
    }
    @PostMapping("/savetrx")
    public TransaksiDto saveTryTrx(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi=conversiDtoToEntity(transaksiDto);
        transaksiService.insertDataTransaksi(transaksi);
        return conversiEntityToDto(transaksi);
    }

    @PostMapping("/add/banyak")
    public TransaksiDto[] addBanyakTagihan(@RequestBody TransaksiDto[] listbanyak){
        for(TransaksiDto m : listbanyak){
            transaksirepo.save(conversiDtoToEntity(m));
        }
        return listbanyak;
    }
    @PostMapping("/add/banyaktrx")
    public TransaksiDto[] addBanyakTagihantrx(@RequestBody TransaksiDto[] listbanyak){
        for(TransaksiDto m : listbanyak){
            Transaksi transaksibanyak=conversiDtoToEntity(m);
            transaksiService.insertDataTransaksibanyak(transaksibanyak);
        }
        return listbanyak;
    }
    public List<TransaksiDto> listdata(){
        List<TransaksiDto>list=new ArrayList<TransaksiDto>();
        for(Transaksi m :transaksirepo.findAll()){
            list.add(conversiEntityToDto(m));
        }
        return list;
    }
    public List<Transaksi> listdataEntity(){
        List<Transaksi>listEntity=new ArrayList<Transaksi>();
        for(Transaksi m :transaksirepo.findAll()){
            listEntity.add(m);
        }
        return listEntity;
    }
    @GetMapping("/searchnoTransaksi/{notransaksi}/sukseslogin")
    public List<TransaksiDto> searchNoTrans(@PathVariable String notransaksi){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if (((String.valueOf(m.getNoTransaksi())).toLowerCase()).matches((notransaksi +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchnoTagihan/{notagihan}/sukseslogin")
    public List<TransaksiDto> searchNoTag(@PathVariable String notagihan){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if (((String.valueOf(m.getNoTagihan())).toLowerCase()).matches((notagihan +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchbulan/{bulan}/sukseslogin")
    public List<TransaksiDto> searchbulan(@PathVariable String bulan){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if (((String.valueOf(m.getBulan())).toLowerCase()).matches((bulan +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchnIdUser/{IdUser}/sukseslogin")
    public List<TransaksiDto> searchIdUser(@PathVariable String IdUser){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if ((String.valueOf(m.getIdUser()).toLowerCase()).matches((IdUser +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchnIdPengguna/{IdPenggunaListrik}/sukseslogin")
    public List<TransaksiDto> searchIdPenggunaListrik(@PathVariable String IdPenggunaListrik){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if ((String.valueOf(m.getIdPenggunaListrik()).toLowerCase()).matches((IdPenggunaListrik +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchnnamaPengguna/{namaPenggunaListrik}/sukseslogin")
    public List<TransaksiDto> searchnamaPenggunaListrik(@PathVariable String namaPenggunaListrik){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if ((String.valueOf(m.getNamaPenggunaListrik()).toLowerCase()).matches((namaPenggunaListrik +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    @GetMapping("/searchuserbulan/{IdUser}/{bulan}/sukseslogin")
    public List<TransaksiDto> searchuserbulan(@PathVariable String IdUser,@PathVariable String bulan){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if (((String.valueOf(m.getBulan())).toLowerCase()).matches((bulan +".*").toLowerCase())&&(String.valueOf(m.getIdUser()).toLowerCase()).matches((IdUser +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    public Transaksi conversiDtoToEntity(TransaksiDto transaksiDto){
        Transaksi transaksi = new Transaksi();

        transaksi.setNoTransaksi(transaksiDto.getNoTransaksi());
        if(pelangganrepo.findById(transaksiDto.getIdNoPelanggan()).isPresent()){
            transaksi.setIdNoPelanggan(pelangganrepo.findById(transaksiDto.getIdNoPelanggan()).get());
        }
        if(tagihanrepo.findById(transaksiDto.getNoTagihan()).isPresent()){
            transaksi.setNoTagihan(tagihanrepo.findById(transaksiDto.getNoTagihan()).get());
        }

        return transaksi;
    }
    public TransaksiDto conversiEntityToDto(Transaksi transaksi){
        TransaksiDto transaksiDto=new TransaksiDto();
        transaksiDto.setNoTransaksi(transaksi.getNoTransaksi());
        transaksiDto.setIdNoPelanggan(transaksi.getIdNoPelanggan().getNoPelanggan());
        transaksiDto.setIdUser(transaksi.getIdNoPelanggan().getIdUser().getNoInduk());
        transaksiDto.setNoTagihan(transaksi.getNoTagihan().getNoTagihan());
        transaksiDto.setBiaya(transaksi.getNoTagihan().getBiaya());
        transaksiDto.setBulan(transaksi.getNoTagihan().getBulan());
        transaksiDto.setIdPenggunaListrik(transaksi.getNoTagihan().getIdPenggunaListrik().getIdPengguna());
        transaksiDto.setNamaPenggunaListrik(transaksi.getNoTagihan().getIdPenggunaListrik().getNamaPengguna());
        transaksiDto.setDaya(transaksi.getNoTagihan().getIdPenggunaListrik().getDaya());
        transaksiDto.setKwh(transaksi.getNoTagihan().getKwh());
        transaksiDto.setStatus(transaksi.getNoTagihan().getStatus());
        transaksiDto.setMetodePembayaran(transaksi.getMetodePembayaran().getMetodeBayar());
        transaksiDto.setNoRekeningPLN(transaksi.getMetodePembayaran().getNoRekPLN());
        return transaksiDto;
    }
}
