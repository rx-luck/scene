package com.djc.scene.facade.JwtToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

public class JwtToken {

    public String generateJwtToken(String password,String mobileNumber){
        Algorithm algorithm = Algorithm.HMAC256(password);
        Map<String,Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        Date nowDate = new Date();
        // 设置token过期时间
        Date expireDate = AddDate(nowDate,1);
        String token= JWT.create()
                .withHeader(map)
                .withIssuer("SERVICE") //对应 paylaod iss 节点：签发人
                .withClaim("loginName","fishpro")
                .withSubject("scene")//对应 paylaod sub 节点：主题
                .withAudience("Client")//对应 paylaod aud 节点：受众
                .withIssuedAt(nowDate)//对应 paylaod iat 节点：生效时间
                .withExpiresAt(expireDate) //对应 paylaod  exp 签发人 节点：过期时间
                .sign(algorithm);
        return  token;
    }

    /**
     * 验证 token
     * */
    private static void verifyJWTToken(String token) throws JWTVerificationException {
        Algorithm algorithm=Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("SERVICE")
                .build();
        DecodedJWT jwt =verifier.verify(token);
        String subject=jwt.getSubject();
        Map<String, Claim> claims=jwt.getClaims();
        Claim claim = claims.get("loginName");
        List<String> audience = jwt.getAudience();
        System.out.println("subject 值："+subject);
        System.out.println("audience 值："+audience.get(0));
    }

    /**
     * 时间加减法
     * */
    private static Date AddDate(Date date,Integer minute){
        if(null==date){
            date=new Date();
        }
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }
}
