package com.zxu.splitio.service;

import io.split.client.SplitClient;
import io.split.client.api.SplitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    //autowire the SplitClient
    @Autowired
    private SplitClient splitClient;

    //use splitClient to load the feature and return a treatment
    public String getTreatment(String featureName, String key) {

//        SplitResult result = splitClient.getTreatmentWithConfig(key, featureName);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(result);
//        // Write to a file
//        try (FileWriter writer = new FileWriter("feature.json")) {
//            writer.write(jsonString);
//        }

        return splitClient.getTreatment(key, featureName);
    }
}
