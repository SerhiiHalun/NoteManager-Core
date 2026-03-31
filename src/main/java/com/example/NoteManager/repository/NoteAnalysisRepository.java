package com.example.NoteManager.repository;

import com.example.NoteManager.entity.NoteAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteAnalysisRepository extends JpaRepository<NoteAnalysis, Long> {
}
