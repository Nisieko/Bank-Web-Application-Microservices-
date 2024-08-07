package com.eazybytes.loans.Mapper;

import com.eazybytes.loans.DTO.LoansDTO;
import com.eazybytes.loans.Entity.Loans;

public class LoansMapper {
    public static Loans mapToLoans(LoansDTO loansDTO, Loans loans) {
        loans.setMobileNumber(loansDTO.getMobileNumber());
        loans.setLoanNumber(loansDTO.getLoanNumber());
        loans.setLoanType(loansDTO.getLoanType());
        loans.setTotalLoan(loansDTO.getTotalLoan());
        loans.setAmountPaid(loansDTO.getAmountPaid());
        loans.setOutstandingAmount(loansDTO.getOutstandingAmount());
        return loans;
    }

    public static LoansDTO mapToLoansDTO(Loans loans, LoansDTO loansDTO) {
        loansDTO.setMobileNumber(loans.getMobileNumber());
        loansDTO.setLoanNumber(loans.getLoanNumber());
        loansDTO.setLoanType(loans.getLoanType());
        loansDTO.setTotalLoan(loans.getTotalLoan());
        loansDTO.setAmountPaid(loans.getAmountPaid());
        loansDTO.setOutstandingAmount(loansDTO.getOutstandingAmount());
        return loansDTO;
    }
}
