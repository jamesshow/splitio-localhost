package com.zxu.splitio.service;

import io.split.client.SplitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    //autowire the SplitClient
    @Autowired
    private SplitClient splitClient;

    //use splitClient to load the feature and return a treatment
    public String getTreatment(String featureName, String key) {
        return splitClient.getTreatment(key, featureName);
    }
}
