package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
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
    @Column(name = "datetime_added")
    private LocalDateTime datetime_added;
    @Column(name = "delivery_fee_colombo")
    private Double delivery_fee_colombo;
    @Column(name = "delivery_fee_other")
    private Double delivery_fee_other;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
    @ManyToOne
    @JoinColumn(name = "model_has_brand_id")
    private ModelHasBrand model_has_brand_id;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color_id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "condition_id")
    private Condition condition_id;
    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user_email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Images> product_id = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produc_id")
    private Set<WatchList> produc_id = new HashSet<>();

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

    public LocalDateTime getDatetime_added() {
        return datetime_added;
    }

    public void setDatetime_added(LocalDateTime datetime_added) {
        this.datetime_added = datetime_added;
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

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public ModelHasBrand getModel_has_brand_id() {
        return model_has_brand_id;
    }

    public void setModel_has_brand_id(ModelHasBrand model_has_brand_id) {
        this.model_has_brand_id = model_has_brand_id;
    }

    public Color getColor_id() {
        return color_id;
    }

    public void setColor_id(Color color_id) {
        this.color_id = color_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Condition getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(Condition condition_id) {
        this.condition_id = condition_id;
    }

    public User getUser_email() {
        return user_email;
    }

    public void setUser_email(User user_email) {
        this.user_email = user_email;
    }

    public Set<Images> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Set<Images> product_id) {
        this.product_id = product_id;
    }

    public Set<WatchList> getProduc_id() {
        return produc_id;
    }

    public void setProduc_id(Set<WatchList> produc_id) {
        this.produc_id = produc_id;
    }
}
