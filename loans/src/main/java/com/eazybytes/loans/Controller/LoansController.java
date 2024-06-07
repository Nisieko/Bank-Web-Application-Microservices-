package com.eazybytes.loans.Controller;

import com.eazybytes.loans.Constants.LoanConstants;
import com.eazybytes.loans.DTO.LoansDTO;
import com.eazybytes.loans.DTO.ResponseDTO;
import com.eazybytes.loans.Service.ILoansService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
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
    public ResponseEntity<LoansDTO> fetchLoanDetails(@RequestParam String mobileNumber) {
        LoansDTO loansDTO = iLoansService.fetchLoans(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateLoanDetails(@RequestBody LoansDTO loansDTO) {
        boolean isUpdated = iLoansService.updateLoans(loansDTO);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLoanDetails(@RequestParam String mobileNumber) {
        boolean isDeleted = iLoansService.deleteLoans(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }
}
