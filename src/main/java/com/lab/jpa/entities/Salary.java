package com.lab.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer money;

    public Salary() {
    }

    public Salary(Integer money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Salary{" + "id=" + id + ", money=" + money + '}';
    }
}
