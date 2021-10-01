package com.dotori.golababvoteserver.domain.client_validate.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("client")
@Configuration
@NoArgsConstructor
@Getter @Setter
public class ClientProperty {
    private String secretKey;
    private String clientToken;
}
