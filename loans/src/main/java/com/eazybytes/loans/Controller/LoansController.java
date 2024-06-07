package com.eazybytes.loans.Controller;

import com.eazybytes.loans.Constants.LoanConstants;
import com.eazybytes.loans.DTO.LoansDTO;
import com.eazybytes.loans.DTO.ResponseDTO;
import com.eazybytes.loans.Service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {
    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLoanDetails(@RequestParam String mobileNumber) {
        iLoansService.createLoans(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));

    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDTO> fetchLoansDetails(@RequestParam String mobileNumber) {
        LoansDTO loansDTO = iLoansService.fetchLoans(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDTO);
    }
}
