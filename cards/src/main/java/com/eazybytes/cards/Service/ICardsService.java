package com.eazybytes.cards.Service;

import com.eazybytes.cards.DTO.CardsDTO;

public interface ICardsService {

    void createCard(String mobileNumber);
    CardsDTO fetchCard(String mobileNumber);

    boolean updateCard(CardsDTO cardsDTO);

    boolean deleteCard(String mobileNumber);
}
