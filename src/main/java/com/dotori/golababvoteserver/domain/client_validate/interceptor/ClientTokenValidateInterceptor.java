package com.dotori.golababvoteserver.domain.client_validate.interceptor;

import com.dotori.golababvoteserver.domain.client_validate.utils.ClientTokenValidateUtils;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClientTokenValidateInterceptor implements HandlerInterceptor {
    private final ClientTokenValidateUtils clientTokenValidateUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String clientToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        boolean isValidate = validateToken(clientToken);

        log.info("receives request at server is detected!");
        log.info("endpoint : " + request.getRequestURI());
        log.info("client token : " + clientToken);
        log.info(isValidate ? "token is validated!" : "token is unvalidated!");

        return isValidate;
    }

    private boolean validateToken(String clientToken) {
        try {
            log.info(clientTokenValidateUtils.validateToken(clientToken) + "");
            return clientTokenValidateUtils.validateToken(clientToken);
        } catch (JwtException | IllegalArgumentException e) {
            log.info("exception occurred : " + e.getMessage());
            return false;
        }
    }
}
