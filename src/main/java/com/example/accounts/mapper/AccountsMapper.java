package com.example.accounts.mapper;

import com.example.accounts.dto.AccountsDTO;
import com.example.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO)
    {
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
        accountsDTO.setAccountType(accounts.getAccountType());
        return accountsDTO;
    }
    public static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts)
    {
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());
        accounts.setAccountType(accountsDTO.getAccountType());
        return accounts;
    }

}
