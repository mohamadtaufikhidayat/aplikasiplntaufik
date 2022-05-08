package com.prodemy.pembayaran.listrik.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kdlog")
    private Long Id;

//<<<<<<< HEAD
//=======
    private String role;

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    @Column(name = "waktu")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date(System.currentTimeMillis());
    @Column(name = "pass")
    private String password;

//<<<<<<< HEAD
//=======
    @ManyToOne
    @JoinColumn(name="username", nullable = false)
    private User user;

//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//<<<<<<< HEAD
//=======
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User app) {
        this.user = app;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
//>>>>>>> 52b32ecdee5d332940005f66364861016f5621ec
}
