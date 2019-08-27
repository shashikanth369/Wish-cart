package com.wishcart.wishcart.domain.review.persistence;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

import com.wishcart.wishcart.domain.product.persistence.ProductEntity;

@Data
@Entity
@Table(name = "REVIEWS")
public class ReviewEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "REVIEW_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "REVIEW_ID_SEQ", sequenceName = "REVIEW_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "REVIEW_TEXT")
	private String review;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private ProductEntity product;

}
