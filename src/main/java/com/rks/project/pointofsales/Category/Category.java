package com.rks.project.pointofsales.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ASUS on 26/04/2018.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable{
    @Id
    @NotNull
    @GeneratedValue
    private long id;

    @NotNull
    private String nama;

    protected Category() {}

    public Category(@NotNull String nama) {
        this.nama = nama;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                '}';
    }
}
