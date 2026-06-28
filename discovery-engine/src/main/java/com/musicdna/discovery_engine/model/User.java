package com.musicdna.discovery_engine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    // username / displayName / OAuth tokens → LATER, when auth lands

    // getter
    public Long getId() {
        return id;
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                          // same object reference → equal
        if (o == null || getClass() != o.getClass()) return false;  // null or different type → not equal
        User that = (User) o;
        return id != null && id.equals(that.id);             // equal ONLY if my id is non-null AND matches
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();   // constant — same for every instance, bucket never moves
    }
}