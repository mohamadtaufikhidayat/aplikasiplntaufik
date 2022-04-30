package com.prodemy.pembayaran.listrik.controller;

//import com.prodemy.pembayaran.listrik.Repository.PenggunaListrikrepo;
import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;
import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.TagihanDto;
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.Tagihan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tagihan")
public class Tagihancontroller {
    Logger logger = LoggerFactory.getLogger(Tagihancontroller.class);
    private final Tagihanrepo tagihanrepo;
    private final DataPelRepo datapelrepo;
    public Tagihancontroller(Tagihanrepo tagihanrepo, DataPelRepo datapelrepo) {
        this.tagihanrepo = tagihanrepo;
        this.datapelrepo = datapelrepo;
    }

    @PostMapping("/savedata")
    public TagihanDto[] addtagihan(@RequestBody TagihanDto[] listbanyak) {
        for(TagihanDto m : listbanyak){
            tagihanrepo.save(convertDtoToEntity(m));
        }
        return listbanyak;
    }

    private Tagihan convertDtoToEntity(TagihanDto dto) {
        Tagihan tgh = new Tagihan();
        if(datapelrepo.findById(dto.getIdPenggunaListrik()).isPresent()){
            PenggunaListrik penggunaListrik =  datapelrepo.findById(dto.getIdPenggunaListrik()).get();
            tgh.setIdPenggunaListrik(penggunaListrik);
        }
        tgh.setNoTagihan(dto.getNoTagihan());
        tgh.setBulan(dto.getBulan());
        tgh.setKwh(dto.getKwh());
        tgh.setBiaya(dto.getBiaya());
        tgh.setMetodePembayaran(dto.getMetodePembayaran());
        tgh.setStatus(dto.getStatus());

        return tgh;
    }

    @GetMapping("/cek/{idPenggunaListrik}/{bulan}")
    public DefaultResponse<TagihanDto> getByIdPenggunaListrikAndBulan(@PathVariable Long idPenggunaListrik, @PathVariable String bulan) {
        DefaultResponse<TagihanDto> response = new DefaultResponse<>();
        Optional<Tagihan> optional = tagihanrepo.findByIdPenggunaListrikIdPenggunaAndBulan(idPenggunaListrik, bulan);
        if(optional.isPresent()) {
            response.setPesan("Tagihan bulan ini sudah terbayar");
            response.setData(convertEntityToDto(optional.get()));
        } else {
            response.setPesan("Tagihan bulan ini belum terbayar, silakan melanjutkan pembayaran");
        }
        return response;
    }
    private TagihanDto convertEntityToDto(Tagihan entity) {
        TagihanDto dto = new TagihanDto();
        dto.setIdPenggunaListrik(entity.getIdPenggunaListrik().getIdPengguna());
        dto.setNoTagihan(entity.getNoTagihan());
        dto.setBulan(entity.getBulan());
        dto.setKwh(entity.getKwh());
        dto.setBiaya(entity.getBiaya());
        dto.setMetodePembayaran(entity.getMetodePembayaran());
        dto.setStatus(entity.getStatus());

        return dto;
    }

    @GetMapping("/history/{idPenggunaListrik}")
    public List<TagihanDto> getHistoryByIdPenggunaListrik(@PathVariable Long idPenggunaListrik){
        List<Tagihan> hist = tagihanrepo.findByIdPenggunaListrikIdPengguna(idPenggunaListrik);
        List<TagihanDto> histDto = hist.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return histDto;
    }

    @GetMapping("/alldata")
    public List<TagihanDto> getListTagihan(){
        List<TagihanDto> list = new ArrayList<>();
        for(Tagihan m : tagihanrepo.findAll()) {
            list.add(convertEntityToDto(m));
        }
        return list;
    }

//    @PostMapping("/tgh")
//    public TagihanDto pTagihan(@RequestBody TagihanDto Tagpt){
//        Tagihan tghn = convertToEntity(Tagpt);
//        tagihanrepo.save(tghn);
//        return Tagpt;
//    }

//    private Tagihan convertToEntity(TagihanDto pt) {
//        Tagihan tghn = new Tagihan();
//        if(penggunaListrikrepo.findById(pt.getIdPenggunaListrik()).isPresent()){
//            PenggunaListrik penggunaListrik =  penggunaListrikrepo.findById(pt.getIdPenggunaListrik()).get();
//            tghn.setIdPenggunaListrik(penggunaListrik);
//        }
//        tghn.setNoTagihan(pt.getNoTagihan());
//        tghn.setBulan(pt.getBulan());
//        tghn.setKwh((long) (Math.floor(Math.random() * 100) + 100));
//        Long bi = Long.valueOf(0);
//        if (penggunaListrikrepo.findJenisByIdPengguna(pt.getIdPenggunaListrik()).getJenis()=="RT1") {
//            bi = tghn.getKwh()*1352;
//        }
//        tghn.setBiaya(bi);
//        tghn.setMetodePembayaran(pt.getMetodePembayaran());
//        tghn.setStatus(pt.getStatus());
//
//        return tghn;
//    }

//    public void hitungBiaya() {
//        TagihanDto tagihanDto = new TagihanDto();
//        tagihanDto.setKwh((long) (Math.floor(Math.random() * 100) + 100));
//        if (penggunaListrikrepo.findJenisByIdPengguna(tagihanDto.getIdPenggunaListrik()).getJenis()=="RT1") {
//            tagihanDto.setBiaya(tagihanDto.getKwh()*1352);
//        }
//        tagihanrepo.save(convertDtoToEntity(tagihanDto));
//    }
//
//    @PostMapping("/hitung")
//    public List<TagihanDto> getbiaya() {
//        List<TagihanDto> bi = new ArrayList<>();
//
//        return bi;
//    }

    //        logger.info(String.valueOf(Math.floor(Math.random() * 100) + 100));
//        logger.info(String.valueOf(penggunaListrikrepo.findJenisByIdPengguna("1234").getJenis()));
//        logger.info(String.valueOf(penggunaListrikrepo.findJenisByIdPengguna("1234").getDaya()));

}
