package com.zxu.splitio.config;

import io.split.client.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SplitConfig {

    @Value("${split.json-file}")
    private String splitFeatureFile;

    @Bean
    public SplitClient splitClient() throws Exception {

        //localhost to use splitFetureFile
        if (splitFeatureFile != null && !splitFeatureFile.isEmpty()) {
            SplitClientConfig config = SplitClientConfig.builder()
                    .enableDebug()
                    .build();
            SplitFactory splitFactory = SplitFactoryBuilder.build(splitFeatureFile, config);
            return splitFactory.client();
        }

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
