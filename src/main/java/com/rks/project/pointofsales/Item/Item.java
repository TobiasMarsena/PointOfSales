package com.rks.project.pointofsales.Item;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ASUS on 26/04/2018.
 */
@Entity
@Table(name = "Item")
public class Item implements Serializable{
    @Id
    @NotNull
    private int kode;
    @NotNull
    private String nama;
    @NotNull
    private int category_id;
    @NotNull
    private long harga;
    private String description;

    protected Item() {}

    public Item(@NotNull int kode, @NotNull String nama, @NotNull int category_id, @NotNull long harga) {
        this.kode = kode;
        this.nama = nama;
        this.category_id = category_id;
        this.harga = harga;
    }
    public Item(@NotNull int kode, @NotNull String nama, @NotNull int category_id, @NotNull long harga, String description) {
        this.kode = kode;
        this.nama = nama;
        this.category_id = category_id;
        this.harga = harga;
        this.description = description;
    }

    public int getKode() {
        return kode;
    }
    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public long getHarga() {
        return harga;
    }
    public void setHarga(long harga) {
        this.harga = harga;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "kode=" + kode +
                ", nama='" + nama + '\'' +
                ", category_id=" + category_id +
                ", harga=" + harga +
                ", description='" + description + '\'' +
                '}';
    }
}

