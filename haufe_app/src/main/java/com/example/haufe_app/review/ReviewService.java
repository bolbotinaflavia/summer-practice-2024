package com.example.haufe_app.review;

import com.example.haufe_app.user.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;


    @Autowired
    //we use this template to write a dynamic query
    private MongoTemplate mongoTemplate;
    public ResponseEntity<Review> createReview(String userId,String groupId, String link, String body, String where_to_watch, String rating, String poster){

        Review review=new Review(link,body,where_to_watch,rating,poster);
        reviewRepo.insert(review);

        mongoTemplate.update(User.class)
                .matching(Criteria.where("userId").is(userId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

//        review.setUserId(new ObjectId("userId"));
//        if(groupId!=null)
//            review.setGroupId(new ObjectId("groupId"));
        reviewRepo.save(review);
        return ResponseEntity.ok(review);
    }
}
