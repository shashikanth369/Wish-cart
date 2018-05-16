package com.wishcart.wishcart.domain.category.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity implements Serializable{
}
