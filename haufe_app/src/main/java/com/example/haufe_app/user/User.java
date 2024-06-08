package com.example.haufe_app.user;

import com.example.haufe_app.group.Group;
import com.example.haufe_app.review.Review;
import com.example.haufe_app.token.Token;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user")
@RequestMapping("/users")

public class User implements UserDetails {

    @Id
    private ObjectId id;
    private String name;
    private String username;
    private String email;
    private String password;
    //no need for enumerated because mongodb will handle it
    private UserRole userRole;
    private String secret;

    //refreshToken
    @DBRef
    private List<Token> tokens;

    @DocumentReference
    private List<Review> reviewIds;

    @DBRef
    private List<Group> groups;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

