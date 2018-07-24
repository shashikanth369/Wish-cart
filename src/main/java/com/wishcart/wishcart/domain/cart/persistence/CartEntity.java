package com.wishcart.wishcart.domain.cart.persistence;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.product.Product;
import com.wishcart.wishcart.domain.product.persistence.ProductEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "CART")
public class CartEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "CART_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CART_ID_SEQ", sequenceName = "CART_ID_SEQ",allocationSize=1)
    @Column(name="ID", unique=true, nullable=false)
    private  Long id;


    @OneToOne
    @JoinColumn(name = "CUST_ID")
    private CustomerEntity cuatomer;

    @Column(name = "TOTAL")
    private Long total;

    @OneToMany(mappedBy = "cartEntity")
    private List<ProductEntity> prducts;

}
