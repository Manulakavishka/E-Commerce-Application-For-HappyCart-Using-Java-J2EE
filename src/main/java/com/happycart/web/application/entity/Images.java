package com.happycart.web.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Images {
    @Id
    @Column(name = "code")
    private String code;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }
}
