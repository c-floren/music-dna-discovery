package com.musicdna.discovery_engine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "tracks", indexes = {
    @Index(name = "idx_tracks_artist", columnList = "artist"),
    @Index(name = "idx_tracks_tempo", columnList = "tempo"),
    @Index(name = "idx_tracks_valence", columnList = "valence"),
    @Index(name = "idx_tracks_energy", columnList = "energy"),
    @Index(name = "idx_tracks_danceability", columnList = "danceability"),
    @Index(name = "idx_tracks_acousticness", columnList = "acousticness")
})
public class Track {
    @Id
    @Column(name = "id", length = 22, nullable = false)
    private String id;

    @Column(name = "name", nullable = false, columnDefinition = "text")
    private String name;

    @Column(name = "artist", nullable = false, columnDefinition = "text")
    private String artist;

    @Column(name = "tempo", nullable = false)
    private float tempo;

    @Column(name = "valence", nullable = false)
    private float valence;

    @Column(name = "energy", nullable = false)
    private float energy;

    @Column(name = "danceability", nullable = false)
    private float danceability;

    @Column(name = "acousticness", nullable = false)
    private float acousticness;

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public float getTempo() {
        return tempo;
    }

    public float getValence() {
        return valence;
    }

    public float getEnergy() {
        return energy;
    }

    public float getDanceability() {
        return danceability;
    }

    public float getAcousticness() {
        return acousticness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                    // reflexivity / fast path
        if (o == null || getClass() != o.getClass())   // null + strict type (dodges Hibernate proxy)
            return false;
        Track track = (Track) o;                        // safe cast — type already checked
        return id.equals(track.id);                     // natural key: stable, non-null
    }

    @Override
    public int hashCode() {
        return id.hashCode();                           // stable forever — id never changes
    }
}
