package com.wishcart.wishcart.domain.product.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
public class ProductEntity implements Serializable{
}
