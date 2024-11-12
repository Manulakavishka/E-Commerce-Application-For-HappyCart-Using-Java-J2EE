package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "newproduct")
public class NewProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "description" , length = 500)
    private String description;

    @Column(name = "title" )
    private String title;
    @Column(name = "delivery_fee_colombo")
    private Double delivery_fee_colombo;
    @Column(name = "delivery_fee_other")
    private Double delivery_fee_other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDelivery_fee_colombo() {
        return delivery_fee_colombo;
    }

    public void setDelivery_fee_colombo(Double delivery_fee_colombo) {
        this.delivery_fee_colombo = delivery_fee_colombo;
    }

    public Double getDelivery_fee_other() {
        return delivery_fee_other;
    }

    public void setDelivery_fee_other(Double delivery_fee_other) {
        this.delivery_fee_other = delivery_fee_other;
    }
}
