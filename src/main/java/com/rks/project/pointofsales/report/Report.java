package com.rks.project.pointofsales.report;


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
@Table(name = "report")
public class Report implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String username;
    @NotNull
    private int amount;
    @NotNull
    private String payment_method;
    @NotNull
    private long total_price;

    protected Report() {}

    public Report(@NotNull String username, @NotNull int amount, @NotNull String payment_method, @NotNull long total_price) {
        this.username = username;
        this.amount = amount;
        this.payment_method = payment_method;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public long getTotal_price() {
        return total_price;
    }
    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", amount=" + amount +
                ", payment_method='" + payment_method + '\'' +
                ", total_price=" + total_price +
                '}';
    }
}
