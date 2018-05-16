package com.wishcart.wishcart.domain.card.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CARD")
public class CardEntity implements Serializable{
}
