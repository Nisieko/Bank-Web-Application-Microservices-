package com.eazybytes.accounts.Service.client;


import com.eazybytes.accounts.DTO.CardsDTO;
import com.eazybytes.accounts.DTO.LoansDTO;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<CardsDTO> fetchCardDetails(@RequestParam String mobileNumber);
}
