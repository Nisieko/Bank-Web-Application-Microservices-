package com.eazybytes.cards.DTO;


import lombok.Data;

@Data
public class CardsDTO {
    private String cardNumber;

    private String cardType;

    private String mobileNumber;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

}
