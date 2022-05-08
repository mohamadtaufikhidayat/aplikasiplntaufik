package com.prodemy.pembayaran.listrik.model.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name="tb_app")
public class User {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "41021031"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "id_app")
    private Long noInduk;
    @Column
    private String password;
    @Column
    private String email;

    @Column(name = "no_pegawai",unique = true)
    private Long data;

    @OneToOne
    @JoinColumn(name = "no_peg")
    private Admin pegawai;

    public Long getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(Long userid) {
        this.noInduk = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }


}

