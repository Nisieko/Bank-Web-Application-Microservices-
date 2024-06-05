package com.eazybytes.cards.Service.impl;

import com.eazybytes.cards.Constants.CardsConstants;
import com.eazybytes.cards.DTO.CardsDTO;
import com.eazybytes.cards.Entity.Cards;
import com.eazybytes.cards.Exception.CardAlreadyExistsException;
import com.eazybytes.cards.Exception.ResourceNotFoundException;
import com.eazybytes.cards.Mapper.CardsMapper;
import com.eazybytes.cards.Repository.CardsRepository;
import com.eazybytes.cards.Service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;
    @Override
    public void createCard(CardsDTO cardsDTO) {
        Cards cards = CardsMapper.mapToCards(cardsDTO, new Cards());
        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(cards.getMobileNumber());
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already exists with the given mobile number" + cards.getMobileNumber());
        }
        cardsRepository.save(createCards(cards.getMobileNumber()));
    }

    @Override
    public CardsDTO fetchCard(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "MobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDTO(card, new CardsDTO());
    }

    @Override
    public boolean updateCard(CardsDTO cardsDTO) {
        boolean isUpdated = false;
        Cards card = cardsRepository.findByCardNumber(cardsDTO.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Card Number", cardsDTO.getCardNumber())
        );
        Cards newCard = CardsMapper.mapToCards(cardsDTO, card);
        cardsRepository.save(newCard);
        isUpdated = true;

        return isUpdated;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        boolean isDeleted = false;
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );
        cardsRepository.deleteById(card.getCardId());
        return true;
    }

    private Cards createCards(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;

    }


}
