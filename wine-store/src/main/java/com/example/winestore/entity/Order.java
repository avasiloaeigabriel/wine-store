//package com.example.winestore.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "orders")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long id;
//
//    @ManyToMany
//    @JoinTable(
//            name="order_wines",joinColumns = @JoinColumn(name="order_id"),inverseJoinColumns = @JoinColumn(name="wine_id")
//    )
//private Set<Wine> wines=new HashSet<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Set<Wine> getWines() {
//        return wines;
//    }
//
//    public void setWines(Set<Wine> wines) {
//        this.wines = wines;
//    }
//}
