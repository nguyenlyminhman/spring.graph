package vn.study.graph.auth.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import vn.study.graph.exception_handlers.EntityException;

import javax.crypto.SecretKey;
import java.security.Key;


@Component
public class JwtUtils {
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generate(JwtUser user){
        return Jwts.builder().setSubject(user.getEmail()).signWith(key).compact();

    }

    public JwtUser validate(String token){
        JwtUser jwtUser;
        try {
            Claims body = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

            jwtUser = new JwtUser();
            jwtUser.setEmail(body.getSubject());
        }catch (JwtException e) {
            throw new EntityException(e.getLocalizedMessage(), token);
        }
        return  jwtUser;
    }
}
