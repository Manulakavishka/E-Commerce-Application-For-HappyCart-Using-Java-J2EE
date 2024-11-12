package com.happycart.web.application.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "watchlist")
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produc_id")
    private Product product_id;

    @ManyToOne
    @JoinColumn(name = "uses_email")
    private User uses_email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public User getUses_email() {
        return uses_email;
    }

    public void setUses_email(User uses_email) {
        this.uses_email = uses_email;
    }
}
