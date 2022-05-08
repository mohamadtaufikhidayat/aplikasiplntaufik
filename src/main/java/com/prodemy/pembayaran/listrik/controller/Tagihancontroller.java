package com.prodemy.pembayaran.listrik.controller;

//<<<<<<< HEAD
//import com.prodemy.pembayaran.listrik.Repository.CatatMeterRepo;
//import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
//import com.prodemy.pembayaran.listrik.Repository.JenisPelangganRepo;
//import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;
//import com.prodemy.pembayaran.listrik.Service.TagihanService;
//import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
//import com.prodemy.pembayaran.listrik.model.dto.TagihanDto;
//import com.prodemy.pembayaran.listrik.model.entity.CatatMeter;
//=======
//import com.prodemy.pembayaran.listrik.Repository.PenggunaListrikrepo;
import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;

import com.prodemy.pembayaran.listrik.Repository.DataPelRepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.TagihanDto;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import com.prodemy.pembayaran.listrik.model.entity.PenggunaListrik;
import com.prodemy.pembayaran.listrik.model.entity.Tagihan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//<<<<<<< HEAD
//import org.springframework.beans.factory.annotation.Autowired;
//=======
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tagihan")
public class Tagihancontroller {
    Logger logger = LoggerFactory.getLogger(Tagihancontroller.class);
//<<<<<<< HEAD
//    @Autowired
//    private final Tagihanrepo tagihanrepo;
//    private final DataPelRepo datapelrepo;
//    private final JenisPelangganRepo jenisPelangganRepo;
//    private final CatatMeterRepo catatMeterRepo;
//    @Autowired
//    private TagihanService tagihanService;
//
//    @Autowired
//    public Tagihancontroller(Tagihanrepo tagihanrepo, DataPelRepo datapelrepo,
//                             JenisPelangganRepo jenisPelangganRepo, CatatMeterRepo catatMeterRepo) {
//        this.tagihanrepo = tagihanrepo;
//        this.datapelrepo = datapelrepo;
//        this.jenisPelangganRepo = jenisPelangganRepo;
//        this.catatMeterRepo = catatMeterRepo;
//=======
    private final Tagihanrepo tagihanrepo;
    private final DataPelRepo datapelrepo;
    public Tagihancontroller(Tagihanrepo tagihanrepo, DataPelRepo datapelrepo) {
        this.tagihanrepo = tagihanrepo;
        this.datapelrepo = datapelrepo;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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
//<<<<<<< HEAD
//        tgh.setNoTagihan(dto.getNoTagihan());
//=======
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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
//<<<<<<< HEAD
//        dto.setNoTagihan(entity.getNoTagihan());
//        dto.setNoUrut(entity.getNoUrut().getNoUrut());
//        dto.setIdPenggunaListrik(entity.getIdPenggunaListrik().getIdPengguna());
//=======
        dto.setIdPenggunaListrik(entity.getIdPenggunaListrik().getIdPengguna());
        dto.setNoTagihan(entity.getNoTagihan());
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
        dto.setBulan(entity.getBulan());
        dto.setKwh(entity.getKwh());
        dto.setBiaya(entity.getBiaya());
        dto.setMetodePembayaran(entity.getMetodePembayaran());
        dto.setStatus(entity.getStatus());

        return dto;
    }
//<<<<<<< HEAD
//    @PostMapping("/savetrx")
//    public TagihanDto insertTrx(@RequestBody TagihanDto tagihanDto) {
//        Tagihan tagihan = convertToEntity(tagihanDto);
//        tagihanService.insertData(tagihan);
//        return convertToDto(tagihan);
//    }
//    @PostMapping("/savenotrx")
//    public TagihanDto insertNoTrx(@RequestBody TagihanDto tagihanDto) {
//        Tagihan tagihan = convertToEntity(tagihanDto);
//        Tagihan entity = tagihanrepo.save(tagihan);
//        entity.setIdPenggunaListrik(tagihan.getNoUrut().getIdPenggunaListrik());
//        entity.setBulan(tagihan.getNoUrut().getBulanini());
//        entity.setKwh(tagihan.getNoUrut().getCttkwh());
//        entity.setBiaya(tagihan.getNoUrut().getCttkwh()*tagihan.getIdPenggunaListrik().getIdJenis().getTarif());
//        tagihanrepo.save(entity);
//        return convertToDto(tagihan);
//    }
//
//    private Tagihan convertToEntity(TagihanDto tagihanDto) {
//        Tagihan tagihan = new Tagihan();
//        if(catatMeterRepo.findById(tagihanDto.getNoUrut()).isPresent()){
//            CatatMeter catatMeter =  catatMeterRepo.findById(tagihanDto.getNoUrut()).get();
//            tagihan.setNoUrut(catatMeter);
//        }
//        return tagihan;
//    }
//
//    private TagihanDto convertToDto(Tagihan tagihan){
//        TagihanDto dto = new TagihanDto();
//        dto.setNoTagihan(tagihan.getNoTagihan());
//        dto.setNoUrut(tagihan.getNoUrut().getNoUrut());
//        dto.setIdPenggunaListrik(tagihan.getIdPenggunaListrik().getIdPengguna());
//        dto.setBulan(tagihan.getNoUrut().getBulanini());
//        dto.setKwh(tagihan.getNoUrut().getCttkwh());
//        dto.setBiaya(tagihan.getNoUrut().getCttkwh()*tagihan.getIdPenggunaListrik().getIdJenis().getTarif());
//        return dto;
//    }
//
//    @PutMapping("/pembayaran")
//    public TagihanDto up(@RequestBody TagihanDto tagihanDto) {
//        Tagihan tagihan = convertIniToEntity(tagihanDto);
//        Tagihan entity = tagihanrepo.save(tagihan);
//        entity.setStatus("Lunas");
//        tagihanrepo.save(entity);
//        return convertIniToDto(entity);
//    }
//
//    @PutMapping("/tespembayaran")
//    public DefaultResponse<TagihanDto> update(@RequestBody TagihanDto tagihanDto) {
//        DefaultResponse<TagihanDto> response = new DefaultResponse<>();
//        Tagihan tagihan = convertIniToEntity(tagihanDto);
//        Tagihan entity = tagihanrepo.save(tagihan);
//        if(entity.getMetodePembayaran().isEmpty()) {
//            response.setPesan("Pembayaran gagal, silakan coba lagi");
//        } else {
//            response.setPesan("Pembayaran berhasil");
//            entity.setStatus("Lunas");
//            tagihanrepo.save(entity);
//            response.setData(convertIniToDto(entity));
//        }
//        return response;
//    }
//
//    private Tagihan convertIniToEntity(TagihanDto tagihanDto) {
//        Tagihan tagihan = new Tagihan();
//        tagihan.setNoTagihan(tagihanDto.getNoTagihan());
//        if(catatMeterRepo.findById(tagihanDto.getNoUrut()).isPresent()){
//            CatatMeter catatMeter =  catatMeterRepo.findById(tagihanDto.getNoUrut()).get();
//            tagihan.setNoUrut(catatMeter);
//        }
//        if(datapelrepo.findById(tagihanDto.getIdPenggunaListrik()).isPresent()){
//            PenggunaListrik penggunaListrik =  datapelrepo.findById(tagihanDto.getIdPenggunaListrik()).get();
//            tagihan.setIdPenggunaListrik(penggunaListrik);
//        }
//        tagihan.setBulan(tagihanDto.getBulan());
//        tagihan.setKwh(tagihanDto.getKwh());
//        tagihan.setBiaya(tagihanDto.getBiaya());
//        tagihan.setMetodePembayaran(tagihanDto.getMetodePembayaran());
//
//        return tagihan;
//    }
//
//    private TagihanDto convertIniToDto(Tagihan tagihan){
//        TagihanDto dto = new TagihanDto();
//        dto.setNoTagihan(tagihan.getNoTagihan());
//        dto.setNoUrut(tagihan.getNoUrut().getNoUrut());
//        dto.setIdPenggunaListrik(tagihan.getIdPenggunaListrik().getIdPengguna());
//        dto.setBulan(tagihan.getBulan());
//        dto.setKwh(tagihan.getKwh());
//        dto.setBiaya(tagihan.getBiaya());
//        dto.setMetodePembayaran(tagihan.getMetodePembayaran());
//        dto.setStatus(tagihan.getStatus());
//        return dto;
//    }
//
//    @GetMapping("/tghn/{idPenggunaListrik}/{bulan}")
//    public List<TagihanDto> getTagihan(@PathVariable Long idPenggunaListrik, @PathVariable String bulan){
//        List<Tagihan> tghn = tagihanrepo.findAllByIdPenggunaListrikIdPenggunaAndBulan(idPenggunaListrik, bulan);
//        List<TagihanDto> tdto = tghn.stream().map(this::convertIniToDto).collect(Collectors.toList());
//        return tdto;
//    }
//
//    @GetMapping("/tghn/{idPenggunaListrik}")
//    public List<TagihanDto> getTagihanbyId(@PathVariable Long idPenggunaListrik){
//        List<Tagihan> tghn = tagihanrepo.findByIdPenggunaListrikIdPengguna(idPenggunaListrik);
//        List<TagihanDto> tdto = tghn.stream().map(this::convertIniToDto).collect(Collectors.toList());
//        return tdto;
//    }
//
//    @GetMapping("/all")
//    public List<TagihanDto> getListAll(){
//        List<TagihanDto> list = new ArrayList<>();
//        for(Tagihan m : tagihanrepo.findAll()) {
//            list.add(convertToDto(m));
//=======

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
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
        }
        return list;
    }

//<<<<<<< HEAD
//
//
//
//
//
//
////    @PostMapping("/tgh")
////    public TagihanDto insertBiaya(@RequestBody TagihanDto dto){
////        Tagihan tagihan = convertToEntity(dto);
////        tagihanService.insertBiaya(tagihan);
////        return convertToDto(tagihan);
//=======
//    @PostMapping("/tgh")
//    public TagihanDto pTagihan(@RequestBody TagihanDto Tagpt){
//        Tagihan tghn = convertToEntity(Tagpt);
//        tagihanrepo.save(tghn);
//        return Tagpt;
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
//    }

//    private Tagihan convertToEntity(TagihanDto pt) {
//        Tagihan tghn = new Tagihan();
//<<<<<<< HEAD
////        if(datapelrepo.findById(pt.getIdPenggunaListrik()).isPresent()){
////            PenggunaListrik penggunaListrik =  datapelrepo.findById(pt.getIdPenggunaListrik()).get();
////            tghn.setIdPenggunaListrik(penggunaListrik);
////        }
//////        tghn.setNoTagihan(pt.getNoTagihan());
////        tghn.setBulan(pt.getBulan());
////        tghn.setKwh(pt.getKwh());
//////        tghn.setKwh((long) (Math.floor(Math.random() * 100) + 100));
////        Long bi = Long.valueOf(0);
////        if (datapelrepo.findJenisByIdPengguna(pt.getIdPenggunaListrik()).getJenis()=="RT1") {
//=======
//        if(penggunaListrikrepo.findById(pt.getIdPenggunaListrik()).isPresent()){
//            PenggunaListrik penggunaListrik =  penggunaListrikrepo.findById(pt.getIdPenggunaListrik()).get();
//            tghn.setIdPenggunaListrik(penggunaListrik);
//        }
//        tghn.setNoTagihan(pt.getNoTagihan());
//        tghn.setBulan(pt.getBulan());
//        tghn.setKwh((long) (Math.floor(Math.random() * 100) + 100));
//        Long bi = Long.valueOf(0);
//        if (penggunaListrikrepo.findJenisByIdPengguna(pt.getIdPenggunaListrik()).getJenis()=="RT1") {
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
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
//<<<<<<< HEAD
//=======
////
////    @PostMapping("/hitung")
////    public List<TagihanDto> getbiaya() {
////        List<TagihanDto> bi = new ArrayList<>();
////
////        return bi;
////    }
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec

    //        logger.info(String.valueOf(Math.floor(Math.random() * 100) + 100));
//        logger.info(String.valueOf(penggunaListrikrepo.findJenisByIdPengguna("1234").getJenis()));
//        logger.info(String.valueOf(penggunaListrikrepo.findJenisByIdPengguna("1234").getDaya()));

}
