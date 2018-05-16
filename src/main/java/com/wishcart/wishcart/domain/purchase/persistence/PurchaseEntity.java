package com.wishcart.wishcart.domain.purchase.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity implements Serializable{
}
