package com.TaskManageMent0.Security;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TokenBlockListService {

    private final Set<String> killedToken  = ConcurrentHashMap.newKeySet() ;

    public void killedToken(String token )
    {
        killedToken.add(token) ;

    }

    public boolean isBlockToken(String token )
    {
         return killedToken.contains(token) ;
    }

    public void BlockToken(String token ) {


        killedToken.add(token) ;

    }
}
