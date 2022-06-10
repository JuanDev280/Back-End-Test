package com.back.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private String name;
    private String last_name;
    private String email;
    private String cel;
    private String rol;
    private String username;
    private String pwd;

    public Usuario() {
    }
  
    public Usuario(Integer id_user) {
        this.id_user = id_user;
    }

    public Usuario(Integer id_user, String name, String last_name, String email, String cel, String rol, String username, String pwd) {
        this.id_user = id_user;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.cel = cel;
        this.rol = rol;
        this.username = username;
        this.pwd = pwd;
    }
}
