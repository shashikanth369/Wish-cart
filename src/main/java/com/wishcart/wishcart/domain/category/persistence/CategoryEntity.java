package com.wishcart.wishcart.domain.category.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

import com.wishcart.wishcart.domain.product.persistence.ProductEntity;

@Data
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity implements Serializable {

	@Id
	@GeneratedValue(generator = "CATEGORY_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CATEGORY_ID_SEQ", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private List<ProductEntity> products = new ArrayList<>();

	@Column(name = "CATEGORY")
	private String category;

}
