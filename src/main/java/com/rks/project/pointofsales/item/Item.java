package com.rks.project.pointofsales.item;

import com.rks.project.pointofsales.category.Category;

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
    private Category category;
    @NotNull
    private long price;
    private String description;

    protected Item() {}

    public Item(@NotNull int code, @NotNull String name, @NotNull Category category, @NotNull long price, String description) {
        this.code = code;
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
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
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

