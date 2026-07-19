package com.musicdna.discovery_engine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;

@Service
public class RecommendationService {

    private final Map<DiscoveryVector, RecommendationStrategy> byVector = new HashMap<>();

    public RecommendationService(List<RecommendationStrategy> strategies) {
        for (RecommendationStrategy strategy : strategies) {
            byVector.put(strategy.getVector(), strategy);   // key = the vector it handles
        }
    }

    public List<Track> recommend(DiscoveryVector vector, Track seed) {
        RecommendationStrategy strategy = byVector.get(vector);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for vector: " + vector);
        }
        return strategy.recommend(seed);
    }
}
