package com.TaskManageMent0.Security;

import com.TaskManageMent0.Enum.Permission;
import com.TaskManageMent0.Enum.Role;

import java.util.*;

public class PermissionConfig {


    public static Map< Role, Set<Permission>> getRolePermission()
    {

        Map< Role, Set<Permission>> map = new HashMap<>();

        map.put( Role.ADMIN , new HashSet<>(Arrays.asList(

                Permission.ISSUE_CREATE,
                Permission.ISSUE_VIEW ,
                Permission.ISSUE_ASSIGN,
                Permission.ISSUE_EDIT,
                Permission.ISSUE_DELETE,
                Permission.COMMENT_ADD,
                Permission.COMMENT_DELETE,
                Permission.USER_MANAGE

             ))

        );

        map.put( Role.MANAGER , new HashSet<>(Arrays.asList(

                        Permission.ISSUE_CREATE,
                        Permission.ISSUE_ASSIGN,
                        Permission.ISSUE_EDIT,
                        Permission.ISSUE_DELETE,
                        Permission.COMMENT_ADD


                ))

        );


        map.put( Role.DEVELOPER , new HashSet<>(Arrays.asList(


                Permission.ISSUE_VIEW ,

                Permission.ISSUE_EDIT,

                Permission.COMMENT_ADD


                ))

        );

        map.put( Role.TESTER, new HashSet<>(Arrays.asList(


                        Permission.ISSUE_VIEW ,
                        Permission.COMMENT_ADD


                ))

        );

        return map ;


    }

}
