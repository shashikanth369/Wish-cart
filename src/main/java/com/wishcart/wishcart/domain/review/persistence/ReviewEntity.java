package com.wishcart.wishcart.domain.review.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "REVIEWS")
public class ReviewEntity implements Serializable{
}
