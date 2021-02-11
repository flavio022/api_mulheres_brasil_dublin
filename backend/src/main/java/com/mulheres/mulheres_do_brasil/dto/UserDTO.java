package com.mulheres.mulheres_do_brasil.dto;

import com.mulheres.mulheres_do_brasil.entities.User;

import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private UUID id;
    private String name;
    private String perfil_image;
    private String email;
    private String password;

    public UserDTO(){

    }
    public UserDTO(User user) {
        this.id = user.getId();
        this.name= user.getName();
        this.perfil_image = user.getEmail();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerfil_image() {
        return perfil_image;
    }

    public void setPerfil_image(String perfil_image) {
        this.perfil_image = perfil_image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
