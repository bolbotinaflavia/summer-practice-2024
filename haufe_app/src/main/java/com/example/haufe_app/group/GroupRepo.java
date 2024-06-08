package com.example.haufe_app.group;

import com.example.haufe_app.review.Review;
import com.example.haufe_app.token.Token;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends MongoRepository<Group, ObjectId> {
    @Aggregation(pipeline = {
            "{$lookup: {from: 'user', localField: 'user.id', foreignField: '_id', as: 'userId'}}"
    })
    List<Group> findAllValidGroupByUserId(ObjectId userId);
}
