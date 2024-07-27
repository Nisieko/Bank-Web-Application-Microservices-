package com.eazybytes.accounts.Service.impl;

import com.eazybytes.accounts.DTO.AccountsDTO;
import com.eazybytes.accounts.DTO.CardsDTO;
import com.eazybytes.accounts.DTO.CustomerDetailsDTO;
import com.eazybytes.accounts.DTO.LoansDTO;
import com.eazybytes.accounts.Entity.Accounts;
import com.eazybytes.accounts.Entity.Customer;
import com.eazybytes.accounts.Exception.ResourceNotFoundException;
import com.eazybytes.accounts.Mapper.AccountsMapper;
import com.eazybytes.accounts.Mapper.CustomerMapper;
import com.eazybytes.accounts.Repository.AccountsRepository;
import com.eazybytes.accounts.Repository.CustomerRepository;
import com.eazybytes.accounts.Service.ICustomersService;
import com.eazybytes.accounts.Service.client.CardsFeignClient;
import com.eazybytes.accounts.Service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomersService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber)
        );

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDTO());
        customerDetailsDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(account, new AccountsDTO()));

        ResponseEntity<LoansDTO> loansDTOResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);

        customerDetailsDTO.setLoansDTO(loansDTOResponseEntity.getBody());

        ResponseEntity<CardsDTO> cardsDTOResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDTO.setCardsDTO(cardsDTOResponseEntity.getBody());
        return customerDetailsDTO;
    }
}
