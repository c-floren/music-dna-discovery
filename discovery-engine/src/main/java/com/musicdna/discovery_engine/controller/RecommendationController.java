package com.musicdna.discovery_engine.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicdna.discovery_engine.model.DiscoveryVector;
import com.musicdna.discovery_engine.model.Track;
import com.musicdna.discovery_engine.service.RecommendationService;

@RestController
@RequestMapping("/api")  // shared prefix
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    
    @GetMapping("/recommendations")
    public List<Track> recommend(@RequestParam String seedId,
                                 @RequestParam DiscoveryVector vector){
        return recommendationService.recommend(vector, seedId);
    }
}
