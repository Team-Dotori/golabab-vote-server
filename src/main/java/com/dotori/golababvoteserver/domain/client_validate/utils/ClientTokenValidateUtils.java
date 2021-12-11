package com.dotori.golababvoteserver.domain.client_validate.utils;

import com.dotori.golababvoteserver.domain.client_validate.property.ClientProperty;
import com.dotori.golababvoteserver.global.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@RequiredArgsConstructor
public class ClientTokenValidateUtils extends JwtUtils {
    private final ClientProperty clientProperty;

    public String generateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("client-token", clientProperty.getClientToken());

        return createToken("client token", claims, 30 * 24 * 60);
    }

    public boolean validateToken(String token) {
        AtomicBoolean isValidate = new AtomicBoolean();
        doWithClaimsToToken(token, claims -> {
            String encodedClientToken = claims.get("client-token", String.class);
            isValidate.set(encodedClientToken.equals(clientProperty.getClientToken()));
        });
        return isValidate.get();
    }

    @Override
    protected String getSigningKey() {
        return clientProperty.getSecretKey();
    }
}
