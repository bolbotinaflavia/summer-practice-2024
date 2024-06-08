package com.example.haufe_app.token;

import com.example.haufe_app.config.ApplicationConfig;
import com.example.haufe_app.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="token")
public class Token {

    @Id
    private ObjectId id;

    private String token;

    private ApplicationConfig.TokenType tokeType;

    private boolean expired;

    private boolean revoked;

    //@OneToMany kind of
    @DBRef
    private User user;





}
