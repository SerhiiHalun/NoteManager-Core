package com.example.NoteManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false,length = 1000)
    private String title;
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
    @OneToOne(mappedBy = "note", cascade = CascadeType.ALL)
    private NoteAnalysis analysis;
}
