package com.example.haufe_app.group;

import com.example.haufe_app.review.Review;
import com.example.haufe_app.review.ReviewService;
import com.example.haufe_app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Map<String,String> payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return new ResponseEntity(groupService.createGroup(payload.get("creatorId"),payload.get("groupName")), HttpStatusCode.valueOf(201));
    }
}
