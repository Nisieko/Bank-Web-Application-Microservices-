package com.eazybytes.accounts.Service;


import com.eazybytes.accounts.DTO.CustomerDetailsDTO;

public interface ICustomersService {
    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId);
}
