package com.eazybytes.cards.Controller;

import com.eazybytes.cards.Constants.CardsConstants;
import com.eazybytes.cards.DTO.CardsDTO;
import com.eazybytes.cards.DTO.ResponseDTO;
import com.eazybytes.cards.Service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CardsController {
    private ICardsService iCardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCard(@RequestBody CardsDTO cardsDTO) {
        iCardsService.createCard(cardsDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }
}
