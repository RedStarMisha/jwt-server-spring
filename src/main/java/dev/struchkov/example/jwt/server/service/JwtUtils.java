package dev.struchkov.example.jwt.server.service;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import dev.struchkov.example.jwt.server.domain.JwtAuthentication;
import dev.struchkov.example.jwt.server.domain.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(getRoles(claims).get(0));
//        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
//        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static List<Role> getRoles(Claims claims) {
        final String roles = claims.get("role", String.class);
        return List.of(Role.valueOf(roles));
//        return roles.stream()
//                .map(Role::valueOf)
//                .collect(Collectors.toList());
    }

}
