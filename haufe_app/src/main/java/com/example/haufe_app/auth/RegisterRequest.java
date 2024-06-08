package com.example.haufe_app.auth;

import com.example.haufe_app.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String username;
    private String email;
    private String password;
    private UserRole role;

    //2fa
    private boolean mfaEnabled;

}
