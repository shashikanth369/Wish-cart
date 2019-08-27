package com.wishcart.wishcart.domain.product.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

import com.wishcart.wishcart.domain.cart.persistence.CartEntity;
import com.wishcart.wishcart.domain.category.persistence.CategoryEntity;
import com.wishcart.wishcart.domain.purchase.persistence.PurchaseEntity;
import com.wishcart.wishcart.domain.review.persistence.ReviewEntity;

@Data
@Entity
@Table
public class ProductEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "PRODUCT_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Integer price;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "QTY")
	private Integer qty;

	@Lob
	@Column(name = "PICTURE")
	private byte[] picture;

	@ManyToOne
	@JoinColumn(name = "CART_ID")
	private CartEntity cartEntity;

	@ManyToOne
	@JoinColumn(name = "PURCHASE_ID")
	private PurchaseEntity purchaseEntity;

	@ManyToMany(mappedBy = "products")
	private List<CategoryEntity> categories = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	private List<ReviewEntity> reviews = new ArrayList<>();

}
