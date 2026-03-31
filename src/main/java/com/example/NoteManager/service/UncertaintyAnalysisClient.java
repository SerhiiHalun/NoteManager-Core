package com.example.NoteManager.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UncertaintyAnalysisClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String PYTHON_SERVICE_URL = "http://localhost:8000/analyze";

    public Double analyzeUncertainty(String text){
        try {
            Map<String, String> request = Map.of("text", text);
            Map<String, Object> response = restTemplate.postForObject(PYTHON_SERVICE_URL, request, Map.class);
            return (Double) response.get("uncertainty_score");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
