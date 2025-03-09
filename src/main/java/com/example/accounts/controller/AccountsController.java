package com.example.accounts.controller;

import com.example.accounts.constants.AccountsConstants;
import com.example.accounts.dto.CustomerDTO;
import com.example.accounts.dto.ResponseDTO;
import com.example.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    public IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createDTO(@RequestBody @Valid CustomerDTO customerDTO)
    {
        iAccountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobileNumber)
    {
        CustomerDTO customerDTO=iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestBody CustomerDTO customerDTO)
    {
        boolean isUpdated=iAccountsService.updateAccount(customerDTO);
        if(isUpdated)
        {
            return ResponseEntity.status(HttpStatus.OK).body((new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200)));
        }
        else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body((new ResponseDTO(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE)));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestParam String mobileNumber)
    {
        boolean isUpdated=iAccountsService.deleteAccount(mobileNumber);
        if(isUpdated)
        {
            return ResponseEntity.status(HttpStatus.OK).body((new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200)));
        }
        else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body((new ResponseDTO(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE)));
        }
    }

}
