package com.example.haufe_app.review;

import com.example.haufe_app.comment.Comment;
import com.example.haufe_app.group.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="review")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    private ObjectId id;

    @DBRef
    private ObjectId userId;
    @DBRef
    private ObjectId groupId;

    private String link;
    private String body;

    private String where_to_watch;

    private String rating;

    private String poster;

    @DBRef
    private List<Comment> comments;


    public Review(String link, String body, String where_to_watch, String rating, String poster) {
        this.link = link;
        this.body = body;
        this.where_to_watch = where_to_watch;
        this.rating = rating;
        this.poster = poster;
    }
}
