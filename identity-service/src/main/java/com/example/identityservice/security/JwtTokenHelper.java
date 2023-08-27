package com.example.identityservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

//    public static final long JWT_TOKEN_VALIDITY=5*60*60;
//    private String secret="jwtTokenKey";

    //Retrieve Username from Token
//    public String getUsernameFromToken(String token){
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    //Retrieve expiration date from Token
//    public Date getExpirationDateFromToken(String token){
//        return getClaimFromToken(token,Claims::getExpiration);
//    }

//    public <T>T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
//        final Claims claims=getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }

    //To retrieve information from token with the help of secret key
//    private Claims getAllClaimsFromToken(String token){
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }

//    private Boolean isTokenExpired(String token){
//        final Date expiration=getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }

    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }


    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
