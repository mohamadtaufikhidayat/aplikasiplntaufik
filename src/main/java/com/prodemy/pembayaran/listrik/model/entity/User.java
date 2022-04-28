package com.prodemy.pembayaran.listrik.model.entity;


import javax.persistence.*;

@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    @Column
    private String idUser;
    @Column
    private String password;
    @Column(unique = true)
    private String email;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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


}
