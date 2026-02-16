package com.TaskManageMent0.Client;

import com.TaskManageMent0.Enum.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

public interface UserClient {

    @GetMapping("/api/users/{email}/roles")
    Set <Role> getRoles(@PathVariable("email") String email);

    }


