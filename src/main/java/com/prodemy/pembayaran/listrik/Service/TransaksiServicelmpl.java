package com.prodemy.pembayaran.listrik.Service;

import com.prodemy.pembayaran.listrik.Repository.Pelangganrepo;
import com.prodemy.pembayaran.listrik.Repository.Tagihanrepo;
import com.prodemy.pembayaran.listrik.Repository.Transaksirepo;
import com.prodemy.pembayaran.listrik.Repository.Userrepo;
import com.prodemy.pembayaran.listrik.model.dto.DefaultResponse;
import com.prodemy.pembayaran.listrik.model.dto.TransaksiDto;
import com.prodemy.pembayaran.listrik.model.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransaksiServicelmpl implements TransaksiService{
    @Autowired
    private Transaksirepo transaksirepo;

    public TransaksiServicelmpl(Userrepo userrepo, Tagihanrepo tagihanrepo, Pelangganrepo pelangganrepo) {
        this.userrepo = userrepo;
        this.tagihanrepo = tagihanrepo;
        this.pelangganrepo = pelangganrepo;
    }

    @Override
    public Transaksi insertDataTransaksi(Transaksi transaksi) {
      //  transaksirepo.save(transaksi);
        return transaksirepo.save(transaksi);
    }
    @Override
    public Transaksi insertDataTransaksibanyak(Transaksi transaksibanyak){
        return transaksirepo.save(transaksibanyak);
    }
    @Override
    public Transaksi insertDataTransdeff(Transaksi transaksi,TransaksiDto transaksiDto){
        DefaultResponse<TransaksiDto> response=new DefaultResponse<>();
        if((transaksi.getNoTagihan().getStatus()).equals(null)&&transaksi.getNoTagihan().getBiaya()==transaksiDto.getBiaya()&&transaksi.getMetodePembayaran().getNoRekPLN()==transaksiDto.getNoRekeningPLN()){
            response.setPesan("transaksi berhasil");
            response.setData(transaksiDto);
            transaksirepo.save(transaksi);
        }else{
            response.setPesan("transaksi gagal");
        }
        return transaksirepo.save(transaksi);
    }


    final private Userrepo userrepo;
    final private Tagihanrepo tagihanrepo;
    final private Pelangganrepo pelangganrepo;

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
