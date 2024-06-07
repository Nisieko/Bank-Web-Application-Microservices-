package com.eazybytes.loans.Service;

import com.eazybytes.loans.DTO.LoansDTO;
import com.eazybytes.loans.Entity.Loans;

import java.util.List;
import java.util.Optional;

public interface ILoansService {
    void createLoans(String mobileNumber);

    LoansDTO fetchLoans(String mobileNumber);

    boolean updateLoans(LoansDTO loansDTO);

    boolean deleteLoans(String mobileNumber);
}
