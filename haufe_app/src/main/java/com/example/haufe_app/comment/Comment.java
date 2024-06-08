package com.example.haufe_app.comment;

import com.example.haufe_app.review.Review;
import com.example.haufe_app.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="comment")
public class Comment {
    @Id
    private ObjectId commentId;

    private String text;

    @DBRef
    private ObjectId userId;

    @DBRef
    private ObjectId review;
}
