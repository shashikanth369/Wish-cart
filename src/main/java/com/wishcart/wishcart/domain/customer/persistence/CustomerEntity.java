package com.wishcart.wishcart.domain.customer.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity implements Serializable{
}
