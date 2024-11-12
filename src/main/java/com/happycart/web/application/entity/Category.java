package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "category_name")
    private String category_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Set<Product> category_id = new HashSet<>();

    public Category(Long id) {
        this.id = id;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Set<Product> getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Set<Product> category_id) {
        this.category_id = category_id;
    }

}
