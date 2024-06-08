package com.example.haufe_app.group;

import com.example.haufe_app.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection="group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @DBRef
    private List<User> users;

    @Id
    private ObjectId groupId;
    @DBRef
    private ObjectId creatorId;
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
