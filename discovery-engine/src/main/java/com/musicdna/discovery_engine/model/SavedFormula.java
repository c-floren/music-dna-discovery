package com.musicdna.discovery_engine.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "saved_formula")
public class SavedFormula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscoveryVector discoveryVector;

    @Column(name = "seed_track_id", nullable = false)
    private String seedTrackId;

    @Column(name = "seed_track_name", nullable = true)
    private String seedTrackName;

    @Column(name = "seed_artist_name", nullable = true)
    private String seedArtistName;

    @Column(name = "target_tempo", nullable = true)
    private Double targetTempo;

    @Column(name = "target_valence", nullable = true)
    private Double targetValence;

    @Column(name = "target_energy", nullable = true)
    private Double targetEnergy;

    @CreationTimestamp
    private Instant createdAt;

    // getters and setters
    // id -> getter only
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DiscoveryVector getDiscoveryVector() {
        return discoveryVector;
    }

    public void setDiscoveryVector(DiscoveryVector discoveryVector) {
        this.discoveryVector = discoveryVector;
    }

    public String getSeedTrackId() {
        return seedTrackId;
    }

    public void setSeedTrackId(String seedTrackId) {
        this.seedTrackId = seedTrackId;
    }

    public String getSeedTrackName() {
        return seedTrackName;
    }

    public void setSeedTrackName(String seedTrackName) {
        this.seedTrackName = seedTrackName;
    }

    public String getSeedArtistName() {
        return seedArtistName;
    }

    public void setSeedArtistName(String seedArtistName) {
        this.seedArtistName = seedArtistName;
    }

    public Double getTargetTempo() {
        return targetTempo;
    }

    public void setTargetTempo(Double targetTempo) {
        this.targetTempo = targetTempo;
    }

    public Double getTargetValence() {
        return targetValence;
    }

    public void setTargetValence(Double targetValence) {
        this.targetValence = targetValence;
    }

    public Double getTargetEnergy() {
        return targetEnergy;
    }

    public void setTargetEnergy(Double targetEnergy) {
        this.targetEnergy = targetEnergy;
    }

    // createdAt -> getter only
    public Instant getCreatedAt() {
        return createdAt;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                          // same object reference → equal
        if (o == null || getClass() != o.getClass()) return false;  // null or different type → not equal
        SavedFormula that = (SavedFormula) o;
        return id != null && id.equals(that.id);             // equal ONLY if my id is non-null AND matches
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();   // constant — same for every instance, bucket never moves
    }

}
