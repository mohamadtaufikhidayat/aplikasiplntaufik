package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_assignment")
public class Assignment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @ManyToOne
    @JoinColumn(name = "idPetugas")
    private PetugasPengaduan idPetugas;
    @ManyToOne
    @JoinColumn(name = "no_pengaduan")
    private FormPengaduan noPengaduan;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public PetugasPengaduan getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(PetugasPengaduan idPetugas) {
        this.idPetugas = idPetugas;
    }

    public FormPengaduan getNoPengaduan() {
        return noPengaduan;
    }

    public void setNoPengaduan(FormPengaduan noPengaduan) {
        this.noPengaduan = noPengaduan;
    }


}
