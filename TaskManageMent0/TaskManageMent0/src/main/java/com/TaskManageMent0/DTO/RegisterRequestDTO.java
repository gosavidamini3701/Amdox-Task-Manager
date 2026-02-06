package com.TaskManageMent0.DTO;

import com.TaskManageMent0.Enum.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterRequestDTO {


    public String userName ;

    public String userOfficialEmail ;

    public String password ;

    public Role role ;


}
