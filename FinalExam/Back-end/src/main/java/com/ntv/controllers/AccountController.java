package com.ntv.controllers;


import com.ntv.entities.dto.AccountDto;
import com.ntv.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/account/")
//@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "list-accounts")
    public List<AccountDto> findAllAccounts(){
        return modelMapper.map(accountService.findAllAccounts(),
                new TypeToken<List<AccountDto>>(){}.getType());
    }


}
