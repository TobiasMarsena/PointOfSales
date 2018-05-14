package com.rks.project.pointofsales.users;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ASUS on 17/04/2018.
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String role;
    @NotNull
    private String nama_user;

    protected Users() {}

    public Users(@NotNull String username, @NotNull String password, @NotNull String role, @NotNull String nama_user) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nama_user = nama_user;
    }

    // Getter and Setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getNama_user() {
        return nama_user;
    }
    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    // To String
    @Override
    public String toString() {
        return "users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", nama_user='" + nama_user + '\'' +
                '}';
    }
}
