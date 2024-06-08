package com.example.haufe_app.review;

import com.example.haufe_app.comment.Comment;
import com.example.haufe_app.user.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return new ResponseEntity(reviewService.createReview(payload.get("userId"),payload.get("groupId"),payload.get("body"),payload.get("link"),payload.get("where_to_watch"),payload.get("rating"),payload.get("poster") ), HttpStatusCode.valueOf(201));
    }
}

