package com.wishcart.wishcart.domain.address.persistence;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;

@Table(name = "ADDRESS")
@Entity
@Data
@NoArgsConstructor
public class AddressEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "ADDRESS_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ADDRESS_ID_SEQ", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "STREET_ADDR")
	private String streetAddress;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP")
	private Long zip;

	@Column(name = "COUNTRY")
	private String country;

	@ManyToOne
	@JoinColumn(name = "CUST_ID")
	private CustomerEntity customerAddress;
}
