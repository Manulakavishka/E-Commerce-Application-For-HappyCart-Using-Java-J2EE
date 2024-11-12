package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "model_has_brand")
public class ModelHasBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model_id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand_id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_has_brand_id")
    private Set<Product> model_has_brand_id = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Model getModel_id() {
        return model_id;
    }

    public void setModel_id(Model model_id) {
        this.model_id = model_id;
    }

    public Brand getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
    }

    public Set<Product> getModel_has_brand_id() {
        return model_has_brand_id;
    }

    public void setModel_has_brand_id(Set<Product> model_has_brand_id) {
        this.model_has_brand_id = model_has_brand_id;
    }
}
