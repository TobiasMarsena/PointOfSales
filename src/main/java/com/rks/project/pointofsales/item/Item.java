package com.rks.project.pointofsales.item;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ASUS on 26/04/2018.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable{
    @Id
    @NotNull
    private int code;
    @NotNull
    private String name;
    @NotNull
    private long category_id;
    @NotNull
    private long price;
    private String description;

    protected Item() {}

    public Item(@NotNull int code, @NotNull String name, @NotNull long category_id, @NotNull long price, String description) {
        this.code = code;
        this.name = name;
        this.category_id = category_id;
        this.price = price;
        this.description = description;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getCategory_id() {
        return category_id;
    }
    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "item{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

