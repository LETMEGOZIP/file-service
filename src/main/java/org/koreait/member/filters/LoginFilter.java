package org.koreait.member.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.net.http.HttpHeaders;

@Component
@RequiredArgsConstructor
public class LoginFilter extends GenericFilterBean {

    private final Utils utils;
    private final ObjectMapper om;
    private final RestTemplate restTemplate;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = utils.getAuthToken();
        loginProcess(token);

        chain.doFilter(request, response);
    }

    /**
     * 로그인 처리
     * @param token
     */
    private void loginProcess(String token){
        if(!StringUtils.hasText(token)){
            String apiUrl = utils.serviceUrl("member-service", "/info");
        }

        try{
            String apiUrl = utils.serviceUrl("member-service", "/info");

            HttpHeaders headers = new HttpHeaders();
        }
    }

}
