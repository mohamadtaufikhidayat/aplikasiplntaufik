package com.prodemy.pembayaran.listrik.controller;


import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;
import com.prodemy.pembayaran.listrik.Repository.Transaksirepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.model.dto.TransaksiDto;
import com.prodemy.pembayaran.listrik.model.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/Transaksi")
public class Transaksicontroller {
    final private Transaksirepo transaksirepo;
    final private Userrepo userrepo;
    final private Tagihanrepo tagihanrepo;
    @Autowired
    public Transaksicontroller(Transaksirepo transaksirepo, Userrepo userrepo, Tagihanrepo tagihanrepo) {
        this.transaksirepo = transaksirepo;
        this.userrepo = userrepo;
        this.tagihanrepo = tagihanrepo;
    }

    @PostMapping("/save")
    public TransaksiDto saveTry(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi=conversiDtoToEntity(transaksiDto);
        transaksirepo.save(transaksi);
        return conversiEntityToDto(transaksi);
    }

    @PostMapping("/add/banyak")
    public TransaksiDto[] addBanyakTagihan(@RequestBody TransaksiDto[] listbanyak){
        for(TransaksiDto m : listbanyak){
            transaksirepo.save(conversiDtoToEntity(m));
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
    @GetMapping("/searchnoTransaksi/{notagihan}/sukseslogin")
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
    @GetMapping("/searchnoTransaksi/{IdUser}/sukseslogin")
    public List<TransaksiDto> searchIdUser(@PathVariable String IdUser){
        List<TransaksiDto>list=listdata();
        TransaksiDto vari = new TransaksiDto();
        List<TransaksiDto>listByNotrans=new ArrayList<>();
        for(TransaksiDto m : list) {
            if (((m.getIdUser()).toLowerCase()).matches((IdUser +".*").toLowerCase())) {
                vari=m;
                listByNotrans.add(vari);
            }
        }
        return listByNotrans;
    }
    public Transaksi conversiDtoToEntity(TransaksiDto transaksiDto){
        Transaksi transaksi = new Transaksi();

        transaksi.setNoTransaksi(transaksi.getNoTransaksi());
        if(userrepo.findById(transaksiDto.getIdUser()).isPresent()){
            transaksi.setIdUser(userrepo.findById(transaksiDto.getIdUser()).get());
        }
        if(tagihanrepo.findById(transaksiDto.getNoTagihan()).isPresent()){
            transaksi.setNoTagihan(tagihanrepo.findById(transaksiDto.getNoTagihan()).get());
        }

        return transaksi;
    }
    public TransaksiDto conversiEntityToDto(Transaksi transaksi){
        TransaksiDto transaksiDto=new TransaksiDto();
        transaksiDto.setNoTransaksi(transaksi.getNoTransaksi());
        transaksiDto.setIdUser(transaksi.getIdUser().getIdUser());
        transaksiDto.setNoTagihan(transaksi.getNoTagihan().getNoTagihan());
//        transaksiDto.setBiaya(transaksi.getBiaya());
//        transaksiDto.setTanggal(transaksi.getTanggal());
//        transaksiDto.setIdPenggunaListrik(transaksi.);
        return transaksiDto;
    }
//    @PostMapping("/login")//methode buat login
//    public DefaultResponse<UserDto> loginstatus(@RequestBody UserDto userDto){
//        User user=conversiDtoToEntity(userDto);
//        DefaultResponse<UserDto> responselogin=new DefaultResponse <>();
//        Optional<User> optional=userrepo.findById(user.getIdUser());
//        Optional<User>opp=userrepo.findBypassword(user.getPassword());
//        if(optional.isPresent()){
//            responselogin.setMassage("login berhasil! untuk menu berikutnya diakhir alamat host tambahkan /sukseslogin");
//            responselogin.setData(conversiEntityToDto(user));
//
//        }else{
//            responselogin.setMassage("login gagal,silahakn masukan id yang benar atau silahkan registrasi");
//            responselogin.setData(null);
//        }
//        return responselogin;
//    }
//    public User conversiDtoToEntity(UserDto dto) {
//        User data =new User();
//        data.setIdUser(dto.getIdUser());
//        data.setEmail(dto.getEmail());
//        data.setPassword(dto.getPassword());
//        return data;
//    }
//    public UserDto conversiEntityToDto(User user) {
//        UserDto data =new UserDto();
//        data.setIdUser(user.getIdUser());
//        data.setEmail(user.getEmail());
//        data.setPassword(user.getPassword());
//        return data;
//    }
//    }testtest 2


}

