package com.wishcart.wishcart.domain.purchase.persistence;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.product.persistence.ProductEntity;

@Data
@Entity
@Table(name = "PURCHASE")
@RequiredArgsConstructor
public class PurchaseEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "PURCHASE_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PURCHASE_ID_SEQ", sequenceName = "PURCHASE_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "TOTAL_PRICE")
	private Integer totalPrice;

	@Column(name = "PURCHASE_DATE")
	private LocalDate purchaseDate;

	@Column(name = "DELIVERY_DATE")
	private LocalDate deliveryDate;

	@ManyToOne
	@JoinColumn(name = "CUST_ID")
	private CustomerEntity customerPurchase;

	@OneToMany(mappedBy = "purchaseEntity")
	private List<ProductEntity> products;
}
