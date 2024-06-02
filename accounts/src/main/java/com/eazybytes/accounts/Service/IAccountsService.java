package com.eazybytes.accounts.Service;

import com.eazybytes.accounts.DTO.CustomerDTO;

public interface IAccountsService {
    void createAccount(CustomerDTO customerDTO);

    CustomerDTO fetchAccount(String mobileNumber);

}
