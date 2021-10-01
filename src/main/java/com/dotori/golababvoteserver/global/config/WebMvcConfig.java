package com.dotori.golababvoteserver.global.config;


import com.dotori.golababvoteserver.domain.logger.interceptor.LoggingInterceptor;
import com.dotori.golababvoteserver.domain.client_validate.interceptor.ClientTokenValidateInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    private final ClientTokenValidateInterceptor clientTokenValidateInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingInterceptor);
        registry.addInterceptor(clientTokenValidateInterceptor)
                .excludePathPatterns("/api/v1/toolbox/print-token");
    }
}
