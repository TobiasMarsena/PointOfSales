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
    private int id;

    @NotNull
    private String nama;

    @NotNull
    private int kode;

    @NotNull
    private int harga;

    protected Item() {}

    public Item(@NotNull int kode,@NotNull int id, @NotNull String nama, @NotNull int harga) {
        this.kode = kode;
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKode() {
        return kode;
    }
    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Item{" +
                "kode=" + kode +
                ",id=" + id +
                ", nama='" + nama +
                ", harga='"+ harga + '\'' +
                '}';
    }
}

