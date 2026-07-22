package com.musicdna.discovery_engine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;
import com.musicdna.discovery_engine.repository.TrackRepository;

@Service
public class RecommendationService {

    private final Map<DiscoveryVector, RecommendationStrategy> byVector = new HashMap<>();
    private final TrackRepository trackRepository;

    public RecommendationService(List<RecommendationStrategy> strategies, TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
        for (RecommendationStrategy strategy : strategies) {
            if (byVector.containsKey(strategy.getVector())) {
                throw new IllegalStateException("Duplicate vector: " + strategy.getVector());
            }
        byVector.put(strategy.getVector(), strategy);   // key = the vector it handles
        }
        
    }

    public List<Track> recommend(DiscoveryVector vector, String seedID) {
        RecommendationStrategy strategy = byVector.get(vector);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for vector: " + vector);
        }

        Track seed = trackRepository.findById(seedID)
            .orElseThrow(() -> new IllegalArgumentException("No track with id: " + seedID));
        
        return strategy.recommend(seed);
    }
}
