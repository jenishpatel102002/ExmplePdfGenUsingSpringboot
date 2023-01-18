package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

//Entity class
//classname and filed matched with database all filed and name
@Entity
public class employee {
    @Id
    private String id;
    private String name;
    private Date date;

    public employee() {
    }

    public employee(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
