package com.example.haufe_app.group;

import com.example.haufe_app.user.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    //we use this template to write a dynamic query
    private MongoTemplate mongoTemplate;
    public ResponseEntity<Group> createGroup(String userId, String groupName) {
        Group group=new Group(groupName);
        mongoTemplate.update(User.class)
                .matching(Criteria.where("creatorId").is(userId))
                .apply(new Update().push("groupIds").value(group))
                .first();
//        group.setCreatorId(new ObjectId("userId"));
        groupRepo.save(group);
        return ResponseEntity.ok(group);
    }
}
