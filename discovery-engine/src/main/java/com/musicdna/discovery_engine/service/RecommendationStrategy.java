package com.musicdna.discovery_engine.service;

import java.util.List;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;

public interface RecommendationStrategy {
    DiscoveryVector getVector(); 
    List<Track> recommend(Track seed);
}
