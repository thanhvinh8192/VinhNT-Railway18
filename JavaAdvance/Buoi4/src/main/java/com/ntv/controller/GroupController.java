package com.ntv.controller;

import com.ntv.entity.Group;
import com.ntv.repository.GroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="group")
public class GroupController {

    private GroupRepository groupRepository;

    public GroupController(){
        groupRepository = new GroupRepository();
    }

    @GetMapping("/list-groups")
    public List<Group> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @PostMapping("/create-group")
    public void createGroup(@RequestBody Group newGroup){
        groupRepository.createGroup(newGroup);
    }

}
