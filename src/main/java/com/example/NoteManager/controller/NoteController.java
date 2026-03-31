package com.example.NoteManager.controller;




import com.example.NoteManager.entity.Note;
import com.example.NoteManager.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@Controller
@RequestMapping( "/note")
public class NoteController {
    private final NoteService noteService;


    @GetMapping("/list")
    public ModelAndView allNotes() {
        ModelAndView model = new ModelAndView("note-list");
        model.addObject("notes", noteService.listAll());
        return model;
    }

    @GetMapping("/edit")
    public ModelAndView editNotePage(@RequestParam(name = "id") long id) {
        Note note = noteService.getById(id);
        ModelAndView model = new ModelAndView("note-edit");

        model.addObject("note", note);
        return model;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam(name = "id") long id) {

        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }
    @GetMapping("/add-note")
    public ModelAndView addNotePage(){
        ModelAndView modelAndView = new ModelAndView("add-note");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/add-note")
    public ModelAndView createNote(@ModelAttribute Note note) {
        noteService.saveNoteWithAnalysis(note);
        return new ModelAndView("redirect:/note/list");
    }

}
