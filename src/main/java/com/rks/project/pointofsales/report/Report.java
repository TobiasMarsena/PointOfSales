package com.rks.project.pointofsales.report;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ASUS on 26/04/2018.
 */
@Entity
@Table(name = "report")
public class Report implements Serializable {
    @Id
    private int id;
    private String username;
    private int amount;
    private String payment_method;
    private int total_price;
}
