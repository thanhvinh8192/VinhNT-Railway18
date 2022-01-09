package com.ntv.entities.dto;

import com.ntv.entities.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LoginDto {

    @NonNull
    private int id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private  Account.AccountRoleEnum role;

    @NonNull
    private  String department;
}
