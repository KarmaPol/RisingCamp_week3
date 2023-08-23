package com.example.demo.src.config;

import com.example.demo.src.domain.login.UserSession;
import com.example.demo.src.domain.user.model.UserRole;
import com.example.demo.src.exception.model.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {

    private final AuthConfig authConfig;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String jws = webRequest.getHeader("Authorization");

        if(jws == null || jws.equals("")){
            throw new UnauthorizedException();
        }

        try{
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(authConfig.getJwtKey())
                    .build()
                    .parseClaimsJws(jws);

            String userId = claims.getBody().get("id", String.class);
            String userRole = claims.getBody().get("role", String.class);

            return new UserSession(Long.parseLong(userId), Enum.valueOf(UserRole.class,userRole));
        }
        catch (JwtException e){
            throw new UnauthorizedException();
        }
    }
}
