package com.lab.jpa.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees=new LinkedHashSet<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "Department_id")
//    @OneToMany(mappedBy = "department") //Employee:private Department department;
//    @OneToMany(cascade = CascadeType.PERSIST)
//    private Set<Employee> employees=new LinkedHashSet<>();
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + '}';
    }
    
}
