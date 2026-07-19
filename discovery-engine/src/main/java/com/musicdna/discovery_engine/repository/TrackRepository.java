package com.musicdna.discovery_engine.repository;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.musicdna.discovery_engine.model.Track;

public interface TrackRepository extends JpaRepository<Track, String> {
    @Query("SELECT t FROM Track t " +
       "WHERE t.tempo BETWEEN :low AND :high " +
       "ORDER BY ABS(t.tempo - :seedTempo)")
    List<Track> lockTheRhythm(@Param("low") float low,
                          @Param("high") float high,
                          @Param("seedTempo") float seedTempo,
                          Limit limit);
    List<Track> findByArtist(String artist, Limit limit);

    @Query("SELECT t FROM Track t " + 
        "WHERE t.valence BETWEEN :v - :delta AND :v + :delta " +
        "AND t.energy BETWEEN :e - :delta AND :e + :delta " +
        "AND t.acousticness BETWEEN :a - :delta AND :a + :delta " + 
        "ORDER BY ABS(t.valence - :v) + ABS(t.energy - :e) + ABS(t.acousticness - :a)")
    List<Track> followTheVibe(@Param("delta") float delta,
                          @Param("v") float v,
                          @Param("e") float e,
                          @Param("a") float a,
                          Limit limit);
}
