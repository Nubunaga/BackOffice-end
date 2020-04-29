package com.example.demos.Security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import com.example.demos.exceptions.WrongAuthLevelException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;

@Service
public class JWTDecoder {

    public static class Keys{
        PublicKey pub = null;


        PublicKey getPublic() {return pub;}

        private Keys(){
            String secretTest = System.getenv("Pass");

            try {
                this.pub = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new Base64().decode(secretTest.getBytes())));
            } catch (Exception e) {
                { e.printStackTrace(); System.exit(-1); }
            }
        }
    }

    public void jwtDecode(String key)throws Exception{
        Keys keys = new Keys();
        try {
            JwtParser jws = Jwts.parser()
             .setSigningKey(keys.getPublic());
             jws.parse(key);
        } catch (JwtException e) {
            System.out.println(e);
            throw new WrongAuthLevelException("User not allowed", e);
        }
    }

}