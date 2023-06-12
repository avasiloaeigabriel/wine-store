package com.example.winestore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "wines")
@Getter
@Setter
@NoArgsConstructor

public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @ManyToMany(mappedBy = "wines")
//    private Set<Order> orders = new HashSet<>();


    private Long id;
    private String name;
    private int age;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
