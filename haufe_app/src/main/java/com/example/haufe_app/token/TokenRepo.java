package com.example.haufe_app.token;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepo extends MongoRepository<Token,ObjectId> {

    @Aggregation(pipeline = {
            "{$lookup: {from: 'user', localField: 'user.id', foreignField: '_id', as: 'userId'}}",
            "{$match: {'user._id': :#{#id}, $or: [{'expired': false}, {'revoked': false}]}}"
    })
    List<Token> findAllValidTokensByUserId(ObjectId userId);

    @Query("{ 'token' : ?0 }")
    Optional<Token> findByToken(@Param("token") String token);

}
