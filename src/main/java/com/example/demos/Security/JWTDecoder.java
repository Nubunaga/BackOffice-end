package com.example.demos.Security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.servlet.annotation.ServletSecurity;

import com.example.demos.exceptions.WrongAuthLevelException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;

@ServletSecurity
@Service
public class JWTDecoder {

    private static class Keys{
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

    private JwtParser jws;

    private static Keys keys = new Keys();


    public void jwtDecode(String key)throws Exception{
        try {
             jws = Jwts.parser()
             .setSigningKey(keys.getPublic());
            jws.parse(key);
        } catch (JwtException e) {
            throw new WrongAuthLevelException("User not allowed", e);
        }
    }

}