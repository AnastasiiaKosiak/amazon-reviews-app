package mate.academy.app.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value(value = "${security.jwt.token.expire-length:3000000}")
    private Long VALID_MILLISECONDS;
    @Value(value = "${security.jwt.token.secret-key:secret}")
    private String key;
    private final UserDetailsService userDetailsService;

    public JwtUtil(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    public String createToken(String name, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(name);
        claims.put("roles", roles);
        Date now = new Date();
        Date valid = new Date(now.getTime() + VALID_MILLISECONDS);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(valid)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
    }

    public String getUserName(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException exception) {
            throw new RuntimeException("Expired or invalid JWT token", exception);
        }
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
