package com.org.mymarket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by denis on 02.07.16.
 */
@Entity
@Table(name = "deals")
public class Deal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Buyer buyer;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "deal_product", joinColumns = @JoinColumn(name = "deal_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "amount")
    private Map<Product, Integer> purchases;
    @Column(name = "total")
    private Double total;
    @Column(name = "time")
    private Date date = new Date();

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

    public Map<Product, Integer> getPurchases() {
        return purchases;
    }

    public void setPurchases(Map<Product, Integer> purchases) {
        this.purchases = purchases;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
