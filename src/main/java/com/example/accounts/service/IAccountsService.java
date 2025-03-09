package com.example.accounts.service;

import com.example.accounts.dto.CustomerDTO;

public interface IAccountsService {
    void createAccount(CustomerDTO customerDTO);

    CustomerDTO fetchAccount(String mobileNo);

    boolean updateAccount(CustomerDTO customerDTO);

    boolean deleteAccount(String mobileNo);
}
