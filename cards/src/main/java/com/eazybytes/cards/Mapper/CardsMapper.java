package com.eazybytes.cards.Mapper;

import com.eazybytes.cards.DTO.CardsDTO;
import com.eazybytes.cards.Entity.Cards;

public class CardsMapper {
    public static CardsDTO mapToCardsDTO(Cards cards, CardsDTO cardsDTO) {
        cardsDTO.setCardNumber(cards.getCardNumber());
        cardsDTO.setCardType(cards.getCardType());
        cardsDTO.setMobileNumber(cards.getMobileNumber());
        cardsDTO.setAmountUsed(cards.getAmountUsed());
        cardsDTO.setTotalLimit(cards.getTotalLimit());
        cardsDTO.setAvailableAmount(cards.getAvailableAmount());
        return cardsDTO;
    }

    public static Cards mapToCards(CardsDTO cardsDTO, Cards cards) {
        cards.setCardNumber(cardsDTO.getCardNumber());
        cards.setCardType(cardsDTO.getCardType());
        cards.setMobileNumber(cardsDTO.getMobileNumber());
        cards.setAmountUsed(cardsDTO.getAmountUsed());
        cards.setTotalLimit(cardsDTO.getTotalLimit());
        cards.setAvailableAmount(cardsDTO.getAvailableAmount());
        return cards;
    }
}
