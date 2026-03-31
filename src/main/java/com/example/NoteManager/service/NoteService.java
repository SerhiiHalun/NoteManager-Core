package com.example.NoteManager.service;






import com.example.NoteManager.entity.Note;
import com.example.NoteManager.entity.NoteAnalysis;
import com.example.NoteManager.repository.NoteAnalysisRepository;
import com.example.NoteManager.repository.NoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class NoteService {

    private final UncertaintyAnalysisClient uncertaintyAnalysisClient;
    private final NoteAnalysisService noteAnalysisService ;
    private final NoteRepository noteRepository;


    @Transactional
    public void saveNoteWithAnalysis(Note note) {
        Note savedNote = noteRepository.save(note);

        Double scoreAnalysis = uncertaintyAnalysisClient.analyzeUncertainty(note.getContent());
        noteAnalysisService.saveAnalysisNote(savedNote.getId(), scoreAnalysis);

    }
    public List<Note> listAll(){
        return noteRepository.findAll();
    }
    public void deleteById(long id){
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Note with id " + id + " not found.");
        }
    }
    public void update(Note note){
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new NoSuchElementException("Note with id " + note.getId() + " not found.");
        }
    }
    public Note getById(long id){
        return noteRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Note with id " + id + " not found."));
    }



}
