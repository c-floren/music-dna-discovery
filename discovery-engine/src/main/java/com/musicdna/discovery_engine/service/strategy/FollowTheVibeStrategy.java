package com.musicdna.discovery_engine.service.strategy;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;
import com.musicdna.discovery_engine.repository.TrackRepository;
import com.musicdna.discovery_engine.service.RecommendationStrategy;

@Component
public class FollowTheVibeStrategy implements RecommendationStrategy{
    private final TrackRepository trackRepository;

    public FollowTheVibeStrategy(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public DiscoveryVector getVector() {
        return DiscoveryVector.FOLLOW_THE_VIBE;
    }

    @Override
    public List<Track> recommend(Track seed){
        float delta = 0.15f;
        float v = seed.getValence();
        float e = seed.getEnergy();
        float a = seed.getAcousticness();
        Limit limit = Limit.of(50);
        return trackRepository.followTheVibe(delta, v, e, a, limit);
    }
}

