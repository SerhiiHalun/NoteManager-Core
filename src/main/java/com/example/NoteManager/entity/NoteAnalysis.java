package com.example.NoteManager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "note_analysis")
public class NoteAnalysis {
    @Id
    private Long id;
    @Column(name = "uncertainty_score")
    private Double uncertaintyScore;
    @Column(name = "is_uncertain")
    private boolean isUncertain;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "note_id")
    private Note note;
}
