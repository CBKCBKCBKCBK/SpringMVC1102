package com.lab.jpa.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Department department;
//    @OneToOne(cascade =CascadeType.PERSIST)
//    private Salary salary;
    
    //只寫以上會發生下列問題:
    //org.hibernate.PersistentObjectException: detached entity passed to persist: 
    //com.lab.jpa.entities.Department
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "salary_id")
    private Salary salary;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    // 加入以上這些解決此問題
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "employee_club",
            joinColumns = {
                @JoinColumn(
                        name = "employee_id",
                        referencedColumnName = "id"
                )
            },inverseJoinColumns = {
                @JoinColumn(
                        name = "club_id",
                        referencedColumnName = "id"
                )
            }
    )
    private Set<Club> clubs=new LinkedHashSet<>();

    public Employee() {
    }

    public Employee(String name, Department department, Salary salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
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

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + ", clubs=" + clubs + '}';
    }
}
