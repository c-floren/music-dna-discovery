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
}
