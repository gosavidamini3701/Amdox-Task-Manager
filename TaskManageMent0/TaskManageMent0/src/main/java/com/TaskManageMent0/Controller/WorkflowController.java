package com.TaskManageMent0.Controller;




import com.TaskManageMent0.Entity.WorkFlow;
import com.TaskManageMent0.Entity.WorkFlowTransaction;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.Role;
import com.TaskManageMent0.Service.WorkFlowService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/workflows")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkFlowService workFlowService;

    // Create Workflow
    @PostMapping("/create")
    public ResponseEntity<WorkFlow> create(@RequestBody WorkFlow wf) {
        return ResponseEntity.ok(workFlowService.createWorkFlow(wf));
    }

    // Get all workflows
    @GetMapping("/all")
    public ResponseEntity<List<WorkFlow>> getAll() {
        return ResponseEntity.ok(workFlowService.getAllWorkFlowList());
    }

    // Get workflow by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkFlow> getById(@PathVariable Long id) {
        return ResponseEntity.ok(workFlowService.getById(id));
    }

    // Update workflow
    @PutMapping("/update/{id}")
    public ResponseEntity<WorkFlow> update(@PathVariable Long id,
                                           @RequestBody WorkFlow wf) {
        return ResponseEntity.ok(workFlowService.updateWorkFlow(id, wf));
    }

    // Delete workflow
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        workFlowService.deleteWorkFlow(id);
        return ResponseEntity.ok("Workflow deleted successfully");
    }

    // Get allowed transactions from a status
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<WorkFlowTransaction>> allowed(
            @PathVariable Long id,
            @RequestParam IssueStatus fromStatus) {

        return ResponseEntity.ok(
                workFlowService.allowedTransactions(id, fromStatus)
        );
    }

    // Validate transition
    @PostMapping("/{id}/validate-transaction")
    public ResponseEntity<Boolean> validTransactions(
            @PathVariable Long id,
            @RequestParam IssueStatus fromStatus,
            @RequestParam IssueStatus toStatus,
            @RequestBody Set<Role> userRoles) {

        boolean allowed = workFlowService.isTransactionsAllowed(
                id, fromStatus, toStatus, userRoles
        );

        return ResponseEntity.ok(allowed);
    }

    // Find workflow by name
    @GetMapping("/name")
    public ResponseEntity<WorkFlow> getByName(
            @RequestParam String name) {

        Optional<WorkFlow> workflow = workFlowService.findByName(name);

        return workflow
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
