package com.musicdna.discovery_engine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.musicdna.discovery_engine.model.SavedFormula;

public interface SavedFormulaRepository extends JpaRepository<SavedFormula, Long> {
    List<SavedFormula> findByUserId(Long userId);
}
