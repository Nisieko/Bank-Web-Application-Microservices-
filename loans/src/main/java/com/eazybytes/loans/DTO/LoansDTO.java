package com.eazybytes.loans.DTO;

import com.eazybytes.loans.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoansDTO {
    private String mobileNumber;

    private String loanNumber;

    private String loanType;
    private int totalLoan;


    private int amountPaid;

    private int outstandingAmount;
}
