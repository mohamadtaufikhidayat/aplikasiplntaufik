package com.prodemy.pembayaran.listrik.Service;

import com.prodemy.pembayaran.listrik.Repository.Gangguanrepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GangguanService {
    private final Gangguanrepo gangguanrepo;

    public GangguanService(Gangguanrepo gangguanrepo) {
        this.gangguanrepo = gangguanrepo;
    }

    public int updateStatusGangguan (Long noGangguan){
        return gangguanrepo.updateStatus(noGangguan);
    }
}
