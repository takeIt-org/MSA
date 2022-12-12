package com.example.customergatewayservice.filter;

import com.example.customergatewayservice.filter.AuthorizationHeaderFilter.Config;
import com.example.customergatewayservice.security.JwtTokenProvider;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<Config> {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthorizationHeaderFilter(JwtTokenProvider jwtTokenProvider) {
        super(Config.class);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            HttpHeaders headers = request.getHeaders();
            if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
            }

            String authorizationHeader = Objects.requireNonNull(headers.get(HttpHeaders.AUTHORIZATION)).get(0);

            // JWT 토큰 판별
            String token = authorizationHeader.replace("Bearer", "");

            jwtTokenProvider.validateJwtToken(token);

            String subject = jwtTokenProvider.getUserId(token);

            if (subject.equals("feign")) {
                return chain.filter(exchange);
            }

            if (!jwtTokenProvider.getRoles(token).contains("Customer")) {
                return onError(exchange, "권한이 없습니다.", HttpStatus.UNAUTHORIZED);
            }

            ServerHttpRequest newRequest = request.mutate().header("user-id", subject).build();

            return chain.filter(exchange.mutate().request(newRequest).build());
        };
    }


    static class Config {
    }
}
