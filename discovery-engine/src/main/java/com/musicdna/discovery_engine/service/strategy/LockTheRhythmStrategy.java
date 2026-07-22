package com.musicdna.discovery_engine.service.strategy;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;
import com.musicdna.discovery_engine.repository.TrackRepository;
import com.musicdna.discovery_engine.service.RecommendationStrategy;

@Component
public class LockTheRhythmStrategy implements RecommendationStrategy {
    private final TrackRepository trackRepository;
    
    public LockTheRhythmStrategy(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public DiscoveryVector getVector() {
        return DiscoveryVector.LOCK_THE_RHYTHM;
    }

    @Override
    public List<Track> recommend(Track seed) {
        float tempo = seed.getTempo();
        String id = seed.getId();
        float low = tempo - 5;
        float high = tempo + 5;
        Limit limit = Limit.of(50);
        return trackRepository.lockTheRhythm(low, high, id, tempo, limit);
    }
    
}
