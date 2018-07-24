package com.wishcart.wishcart.domain.card.persistence;

import com.wishcart.wishcart.domain.card.CardType;
import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CARD")
public class CardEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "CARD_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CARD_ID_SEQ", sequenceName = "CARD_ID_SEQ",allocationSize=1)
    @Column(name="ID", unique=true, nullable=false)
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private CardType cardType;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "CVV")
    private Long cvv;

    @Column(name = "EXP_DATE")
    private LocalDate expDate;

    @Column(name = "HOLDER_NAME")
    private String holderName;

    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private CustomerEntity customerCard;

}
