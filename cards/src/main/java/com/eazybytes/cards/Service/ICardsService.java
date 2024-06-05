package com.eazybytes.cards.Service;

import com.eazybytes.cards.DTO.CardsDTO;

public interface ICardsService {

    void createCard(CardsDTO cardsDTO);
    CardsDTO fetchCard(String mobileNumber);

    boolean updateCard(CardsDTO cardsDTO);
}
