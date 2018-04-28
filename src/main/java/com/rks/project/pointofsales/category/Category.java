package com.rks.project.pointofsales.category;

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
    private String name;

    protected Category() {}

    public Category(@NotNull String nama) {
        this.name = nama;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
