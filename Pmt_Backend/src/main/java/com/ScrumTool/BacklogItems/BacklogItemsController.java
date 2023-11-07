package com.ScrumTool.BacklogItems;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BacklogItemsController {

	@Autowired
	Service service;
//    // Returns data of id, backlogName, backlogType columns from the Backlog_Item table
//    @GetMapping("/backlogItems")
//    public List<BacklogItemDto> getAllBacklogItem() {
//        return backlogItemRepository.findBacklogItemColumns();
//    }
    
    @GetMapping("/Tree")
    public List<Tree> getTreeHierarchy() {
        return service.getTree();
 
    }

}
