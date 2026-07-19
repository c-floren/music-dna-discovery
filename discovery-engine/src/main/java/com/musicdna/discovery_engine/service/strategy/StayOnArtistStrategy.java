package com.musicdna.discovery_engine.service.strategy;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;
import com.musicdna.discovery_engine.repository.TrackRepository;
import com.musicdna.discovery_engine.service.RecommendationStrategy;

@Component
public class StayOnArtistStrategy implements RecommendationStrategy {
    private final TrackRepository trackRepository;
    
    public StayOnArtistStrategy(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public DiscoveryVector getVector() {
        return DiscoveryVector.STAY_ON_ARTIST;
    }

    @Override
    public List<Track> recommend(Track seed) {
        String artist = seed.getArtist();
        Limit limit = Limit.of(50);
        return trackRepository.findByArtist(artist, limit);
    }
    
}
