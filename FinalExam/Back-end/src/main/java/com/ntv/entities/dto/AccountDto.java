package com.ntv.entities.dto;

import com.ntv.entities.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AccountDto implements Serializable {

    @NonNull
    private  int id;

    @NonNull
    private  String username;

    @NonNull
    private  String password;

    @NonNull
    private  String firstName;

    @NonNull
    private  String lastName;

    @NonNull
    private  Account.AccountRoleEnum role;

    @NonNull
    private  String department;
}
