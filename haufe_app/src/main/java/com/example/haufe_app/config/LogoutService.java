package com.example.haufe_app.config;

import com.example.haufe_app.token.Token;
import com.example.haufe_app.token.TokenRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {


    private final TokenRepo tokenRepo;
    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        Optional<Token> optionalToken = tokenRepo.findByToken(jwt);

// Check if the token is present in the Optional
        if (optionalToken.isPresent()) {
            // Extract the Token object from the Optional
            Token storedToken = optionalToken.get();
            if (storedToken != null) {
                // Modify the properties of the Token object
                storedToken.setExpired(true);
                storedToken.setRevoked(true);

                // Save the modified Token object
                tokenRepo.save(storedToken);
            }
        }
    }
}
