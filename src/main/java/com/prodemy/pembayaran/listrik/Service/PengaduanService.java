package com.prodemy.pembayaran.listrik.Service;

import com.prodemy.pembayaran.listrik.Repository.FormPengaduanrepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PengaduanService {
    private final FormPengaduanrepo formPengaduanrepo;

    public PengaduanService(FormPengaduanrepo formPengaduanrepo) {
        this.formPengaduanrepo = formPengaduanrepo;
    }

    public int updateStatusComplaint(Long noPengaduan){
        return formPengaduanrepo.updateStatus(noPengaduan);
    }
    public int updateStatusComplaint2(Long noPengaduan){
        return formPengaduanrepo.updateStatus2(noPengaduan);
    }
}
