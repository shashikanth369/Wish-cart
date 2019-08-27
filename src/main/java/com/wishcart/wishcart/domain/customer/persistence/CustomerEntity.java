package com.wishcart.wishcart.domain.customer.persistence;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

import com.wishcart.wishcart.domain.cart.persistence.CartEntity;
import com.wishcart.wishcart.domain.customer.Gender;

@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "CUSTOMER_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CUSTOMER_ID_SEQ", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

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

}
