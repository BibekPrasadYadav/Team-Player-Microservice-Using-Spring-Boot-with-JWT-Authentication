package com.example.apigateway.filter;

import com.example.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

//Webflux dependency is required

    @Autowired
    private RouteValidator routeValidator;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private JwtUtil jwtUtil;
    public AuthenticationFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            if(routeValidator.isSecured.test( exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing Authorization Headers");
                }

                String authHeaders=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

                if(authHeaders!=null && authHeaders.startsWith("Bearer ")){
                    authHeaders=authHeaders.substring(7);
                }

                try{
//                    restTemplate.getForObject("http://IDENTITY-SERVICE/validate?token=" + authHeaders,String.class);
                    jwtUtil.validateToken(authHeaders);
                }catch(Exception e){
                    System.out.println("");
                    throw new RuntimeException("Service is down");
                }
            }

            return chain.filter(exchange);
        });

    }

    public static class Config{}
}
