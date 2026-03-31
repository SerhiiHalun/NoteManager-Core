package com.example.NoteManager.service;

import com.example.NoteManager.entity.Note;
import com.example.NoteManager.entity.NoteAnalysis;
import com.example.NoteManager.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


class NoteServiceTest {
    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById() {
        NoteAnalysis analysis = new NoteAnalysis();
        Note note = new Note(1L, "First Note", "This is the content of the first note.", analysis);

        when(noteRepository.findById(1L)).thenReturn(java.util.Optional.of(note));

        Note foundNote = noteService.getById(1L);
        Assertions.assertEquals(note, foundNote);
    }
}