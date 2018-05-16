package com.wishcart.wishcart.domain.cart.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CART")
public class CartEntity implements Serializable{
}
