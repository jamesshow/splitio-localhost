package com.zxu.splitio.controller;

//create a restful
import com.zxu.splitio.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/feature/{featureName}/{key}")
    public String getFeature(@PathVariable String featureName, @PathVariable String key) {
        return featureService.getTreatment(featureName, key);
    }
}

