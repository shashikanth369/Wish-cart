package com.wishcart.wishcart.domain.customer.persistence;

import com.wishcart.wishcart.domain.address.persistence.AddressEntity;
import com.wishcart.wishcart.domain.card.persistence.CardEntity;
import com.wishcart.wishcart.domain.cart.persistence.CartEntity;
import com.wishcart.wishcart.domain.customer.Gender;
import com.wishcart.wishcart.domain.purchase.Purchase;
import com.wishcart.wishcart.domain.purchase.persistence.PurchaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "CUSTOMER_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CUSTOMER_ID_SEQ", sequenceName = "CUSTOMER_ID_SEQ",allocationSize=1)
    @Column(name="ID", unique=true, nullable=false)
    private  Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE")
    private String mobile;

    @Lob
    @Column(name = "PICTURE")
    private byte[] dp;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private CartEntity cartEntity;

    @OneToMany(mappedBy = "customerCard")
    private List<CardEntity> cards = new ArrayList<>();

    @OneToMany(mappedBy = "customerPurchase")
    private List<PurchaseEntity> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "customerAddress")
    private List<AddressEntity> addresses = new ArrayList<>();
}
