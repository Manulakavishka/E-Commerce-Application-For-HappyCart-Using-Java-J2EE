package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Set<ModelHasBrand> model_id = new HashSet<>();

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

    public Set<ModelHasBrand> getModel_id() {
        return model_id;
    }

    public void setModel_id(Set<ModelHasBrand> model_id) {
        this.model_id = model_id;
    }
}
