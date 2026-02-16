package com.TaskManageMent0.Controller;

import com.TaskManageMent0.Entity.Issue;
import com.TaskManageMent0.Entity.IssueComment;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {

    @Autowired
    private IssueService issueService ;

    @PostMapping("/createIssue")
    public ResponseEntity<Issue> createIssue( @RequestBody Issue issue ){

        return ResponseEntity.ok( issueService.createIssue( issue ) );

    }



        @PutMapping("/updateStatus")
        public ResponseEntity<Issue> updateIssueStatus(
                @RequestParam Long id,
                @RequestParam String performedBy,
                @RequestParam IssueStatus issueStatus) {
            return ResponseEntity.ok( issueService.updateStatus( id, issueStatus, performedBy ) );
        }





    @PostMapping("/{id}/comments")
    public ResponseEntity <IssueComment> addComment(
            @PathVariable("id") Long issueId,
            @RequestBody Map<String, String> body) {

        String commentBody = body.get( "body" );
        String author = body.getOrDefault( "authorEmail", "system@gmail" );

        return ResponseEntity.ok(
                issueService.addComment( issueId, author, commentBody )
        );
    }



    @GetMapping("/search")
    public ResponseEntity <List<Issue>>search( @RequestParam Map<String, String> filter  ){

        return ResponseEntity.ok( issueService.search(filter) );
    }






}
