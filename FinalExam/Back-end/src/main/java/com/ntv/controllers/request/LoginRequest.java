package com.ntv.controllers.request;

import com.ntv.entities.Account;
import com.ntv.entities.dto.LoginDto;
import com.ntv.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/login")
public class LoginRequest {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> login(Principal principal) {
        String username = principal.getName();
        Account entity = accountService.getAccountByUsername(username);

        // convert entity --> dto
        LoginDto login = modelMapper.map(entity, LoginDto.class);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
