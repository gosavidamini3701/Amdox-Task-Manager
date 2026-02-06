package com.TaskManageMent0.DTO;

import com.TaskManageMent0.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequestDTO {



    public String userOfficialEmail ;
    public String password ;



}
