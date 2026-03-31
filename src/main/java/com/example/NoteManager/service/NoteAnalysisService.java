package com.example.NoteManager.service;

import com.example.NoteManager.entity.Note;
import com.example.NoteManager.entity.NoteAnalysis;
import com.example.NoteManager.repository.NoteAnalysisRepository;
import com.example.NoteManager.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteAnalysisService {
    private final NoteRepository noteRepository;
    private final NoteAnalysisRepository noteAnalysisRepository;
    public NoteAnalysisService(NoteRepository noteRepository, NoteAnalysisRepository noteAnalysisRepository) {
        this.noteRepository = noteRepository;
        this.noteAnalysisRepository = noteAnalysisRepository;
    }
    public void saveAnalysisNote(Long noteId, Double uncertaintyScore){
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note not found"));

        NoteAnalysis noteAnalysis = new NoteAnalysis();
        noteAnalysis.setNote(note);
        noteAnalysis.setUncertaintyScore(uncertaintyScore);
        noteAnalysis.setUncertain(uncertaintyScore > 0.5);

        noteAnalysisRepository.save(noteAnalysis);
    }
}
