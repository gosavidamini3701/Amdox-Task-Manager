package com.TaskManageMent0.Security;

import com.TaskManageMent0.Entity.UserAuth;
import com.TaskManageMent0.Enum.Permission;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JWTToken {

    private final Key key  ;

    private final long  expireToken  = 1000L * 60 * 60 * 24 ;

    public JWTToken()
    {
         String secret = System.getenv("JWT_SECRET");


         if(secret == null || secret.isEmpty()){

              secret = "ThisIsAVeryStrongJwtSecretKeyWithAtLeastThirtyTwoChars";


         }

         key = Keys.hmacShaKeyFor(secret.getBytes());

    }

    public String generateToken( UserAuth user )
    {

        Set<Permission> permissions = PermissionConfig.getRolePermission().get(user.getRole());


        Date now = new Date();

        Date expire = new Date( now.getTime() + expireToken );

        return Jwts.builder()

                .setSubject( user.getUserOfficialEmail() )
                .claim("role" , user.getRole().name())
                .claim("permission",permissions.stream().map(Enum::name).collect(Collectors.toList()))
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(key , SignatureAlgorithm.HS256)
                .compact() ;




    }


    public boolean validToken( String token )
    {
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true ;
        }
        catch( JwtException e)
        {
            return false ;
        }
    }

    public Claims getClaim( String token )
    {
          return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getUserEmail(String token )
    {
         return getClaim(token).getSubject() ;
    }

   public String extractToken ( String header )
   {
       if(header != null  && header.startsWith("Bearer "))
       {
             return  header.substring(7);
       }
       return null ;
   }






}
