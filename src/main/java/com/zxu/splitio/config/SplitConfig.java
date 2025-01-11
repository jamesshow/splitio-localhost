package com.zxu.splitio.config;

import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;
import io.split.client.SplitFactory;
import io.split.client.SplitFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SplitConfig {

    @Bean
    public SplitClient splitClient() throws Exception {
        SplitClientConfig config = SplitClientConfig.builder()
                .setBlockUntilReadyTimeout(10000)
                .enableDebug()
                .build();

        SplitFactory splitFactory = SplitFactoryBuilder.build("your-api-key", config);

        SplitClient splitClient = splitFactory.client();
        splitClient.blockUntilReady();
        return splitClient;
    }
}
