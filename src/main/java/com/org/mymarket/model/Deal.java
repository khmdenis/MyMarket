package com.org.mymarket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Entity
@Table(name="deals")

public class Deal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="buyer")
    Buyer buyer;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="deals_products", joinColumns = @JoinColumn(name="deal_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
    @Column(name="purchas")
    List<Product> purchases;
    @Column(name="time")
    Date date = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }
}
