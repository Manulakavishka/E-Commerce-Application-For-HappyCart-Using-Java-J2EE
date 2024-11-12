package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Set<ModelHasBrand> brand_id = new HashSet<>();

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

    public Set<ModelHasBrand> getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Set<ModelHasBrand> brand_id) {
        this.brand_id = brand_id;
    }
}
